
/**
 *
 *
 */
import claudiosoft.pocbase.BasicConsoleLogger;
import claudiosoft.pocbase.POCException;
import claudiosoft.today.Config;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGeneration extends BaseJUnitTest {

    @Test
    public void t01ExcludedDays() throws POCException, NoSuchAlgorithmException {
        Config conf = new Config();
        BasicConsoleLogger.get().info("25/12 is excluded? " + conf.isExcludedDay(LocalDate.of(2024, Month.DECEMBER, 25)));
        Assert.assertTrue(conf.isExcludedDay(LocalDate.of(2024, Month.DECEMBER, 25)));
        BasicConsoleLogger.get().info("15/03 is excluded? " + conf.isExcludedDay(LocalDate.of(2024, Month.MARCH, 15)));
        Assert.assertTrue(!conf.isExcludedDay(LocalDate.of(2024, Month.MARCH, 15)));
    }

    @Test
    public void t01DayOfWeek() throws POCException, NoSuchAlgorithmException {
        Config conf = new Config();
        BasicConsoleLogger.get().info("monday is day of week? " + conf.isDayOfWeek(LocalDate.of(2024, Month.JANUARY, 22)));
        Assert.assertTrue(conf.isDayOfWeek(LocalDate.of(2024, Month.JANUARY, 22)));
        BasicConsoleLogger.get().info("sunday is day of week? " + conf.isDayOfWeek(LocalDate.of(2024, Month.JANUARY, 21)));
        Assert.assertTrue(!conf.isDayOfWeek(LocalDate.of(2024, Month.JANUARY, 21)));
    }

}
