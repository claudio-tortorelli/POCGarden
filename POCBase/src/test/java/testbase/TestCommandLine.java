/**
 *
 *
 */
package testbase;

import claudiosoft.pocbase.BasicConsoleLogger;
import claudiosoft.pocbase.CmdLineArgument;
import claudiosoft.pocbase.CmdLineParams;
import claudiosoft.pocbase.POCException;
import java.io.IOException;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCommandLine extends BaseJUnitTest {

    @Test
    public void t01ParseParams() throws InterruptedException, IOException, POCException {
        HashMap<String, CmdLineArgument> initArgs = new HashMap<>();
        initArgs.put("test", new CmdLineArgument());
        initArgs.put("test2", new CmdLineArgument("", true));
        initArgs.put("path", new CmdLineArgument("path"));
        initArgs.put("num", new CmdLineArgument(1));

        String[] args = new String[4];
        args[0] = "test=true";
        args[2] = "path=c:\\canc";
        args[3] = "num=2";

        boolean missing = false;
        try {
            CmdLineParams.get().parseArgs(initArgs, args);
        } catch (POCException ex) {
            ex.printStackTrace();
            missing = true;
        }
        Assert.assertTrue(missing);

        Assert.assertTrue(initArgs.containsKey("test"));
        Assert.assertTrue(initArgs.get("test").getValueBool() == true);

        Assert.assertTrue(initArgs.containsKey("path"));
        Assert.assertTrue(initArgs.get("path").getValue().equals("c:\\canc"));

        Assert.assertTrue(initArgs.containsKey("num"));
        Assert.assertTrue(initArgs.get("num").getValueInt() == 2);

    }

    @Test
    public void t01BasicLogger() throws InterruptedException, IOException, POCException {
        BasicConsoleLogger logger = BasicConsoleLogger.get();
        logger.info("info message");
        try {
            int a = 0;
            int b = 1 / a;
        } catch (Exception ex) {
            logger.error("error: " + ex.getMessage(), ex);
        }
    }

}
