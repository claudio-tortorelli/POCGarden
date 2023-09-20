/**
 * JarBoxProject - https://github.com/claudio-tortorelli/JarBox/
 *
 * MIT License - 2021
 */
package testbase;

import claudiosoft.pocbase.CmdLineArgument;
import claudiosoft.pocbase.CmdLineParams;
import claudiosoft.pocbase.POCException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBase extends BaseJUnitTest {

    @Test
    public void t01ParseParams() throws InterruptedException, IOException, POCException {
        List<CmdLineArgument> initArgs = new ArrayList<>();
        initArgs.add(new CmdLineArgument("test"));
        initArgs.add(new CmdLineArgument("test2", true));
        initArgs.add(new CmdLineArgument("path"));
        initArgs.add(new CmdLineArgument("num", 1));

        String[] args = new String[4];
        args[0] = "test=true";
        args[1] = "test2";
        args[2] = "path=c:\\canc";
        args[3] = "num=2";

        CmdLineParams.get().parseArgs(initArgs, args);

    }

}
