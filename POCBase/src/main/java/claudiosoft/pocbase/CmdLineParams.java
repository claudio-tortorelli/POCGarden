package claudiosoft.pocbase;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Claudio
 */
public class CmdLineParams {

    private static CmdLineParams params = null;

    public static CmdLineParams get() throws POCException {
        if (params != null) {
            return params;
        }
        params = new CmdLineParams();
        return params;
    }

    private CmdLineParams() {

    }

    public void parseArgs(HashMap<String, CmdLineArgument> initArgs, String[] args) throws POCException {
        for (String arg : args) {
            if (arg == null || arg.isEmpty()) {
                continue;
            }
            String[] splitted = arg.split("=");
            if (splitted.length != 2) {
                continue;
            }
            String param = splitted[0].toLowerCase().trim();
            if (param.isEmpty()) {
                continue;
            }
            String value = splitted[1].trim();

            boolean parsed = false;
            for (String label : initArgs.keySet()) {
                if (!label.trim().equalsIgnoreCase(param)) {
                    continue;
                }
                parsed = true;
                try {
                    initArgs.get(label).setValueInt(Integer.parseInt(value));
                } catch (NumberFormatException ex) {
                    if (value.equalsIgnoreCase("true")) {
                        initArgs.get(label).setValueBool(true);
                    } else if (value.equalsIgnoreCase("false")) {
                        initArgs.get(label).setValueBool(false);
                    } else {
                        initArgs.get(label).setValue(value);
                    }
                }
                break;
            }
            if (!parsed) {
                throw new POCException("unsupported input parameter: " + param);
            }
        }
        for (Map.Entry<String, CmdLineArgument> curPocArg : initArgs.entrySet()) {
            if (curPocArg.getValue().isMissing()) {
                throw new POCException("missing required parameter: " + curPocArg.getKey());
            }
        }
    }
}
