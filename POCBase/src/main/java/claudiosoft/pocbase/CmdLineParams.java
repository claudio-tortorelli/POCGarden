package claudiosoft.pocbase;

import java.util.List;

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

    public void parseArgs(List<CmdLineArgument> initArgs, String[] args) throws POCException {
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
            for (CmdLineArgument curPocArg : initArgs) {
                if (!curPocArg.getLabel().trim().equalsIgnoreCase(param)) {
                    continue;
                }
                parsed = true;

                try {
                    curPocArg.setValueInt(Integer.parseInt(value));
                } catch (NumberFormatException ex) {
                    if (value.equalsIgnoreCase("true")) {
                        curPocArg.setValueBool(true);
                    } else if (value.equalsIgnoreCase("false")) {
                        curPocArg.setValueBool(false);
                    } else {
                        curPocArg.setValue(value);
                    }
                }
                break;
            }
            if (!parsed) {
                throw new POCException("unsupported input parameter: " + param);
            }
        }
        for (CmdLineArgument curPocArg : initArgs) {
            if (curPocArg.isMissing()) {
                throw new POCException("missing required parameter: " + curPocArg.getLabel());
            }
        }
    }
}
