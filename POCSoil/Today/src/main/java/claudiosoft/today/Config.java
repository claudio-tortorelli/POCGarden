package claudiosoft.today;

import claudiosoft.pocbase.BasicConsoleLogger;
import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Claudio
 */
public class Config {

    private final List<Integer> dayOfWeek = new LinkedList<>(); // 1=Monday to 7=Sunday
    private int dailySlot; // expressed in timeUnit
    private double minDailyTaskSlot;
    private final List<String> excludedDays = new LinkedList<>();

    public Config() {
        this(null);
    }

    public Config(File configFile) {
        if (configFile == null || !configFile.exists()) {
            BasicConsoleLogger.get().info("No config file is defined. Using default preferences");
        }

        dayOfWeek.add(1);
        dayOfWeek.add(2);
        dayOfWeek.add(3);
        dayOfWeek.add(4);
        dayOfWeek.add(5);

        minDailyTaskSlot = 2; // TODO should be configurable

        excludedDays.add("0101");
        excludedDays.add("0106");
        excludedDays.add("0425");
        excludedDays.add("0501");
        excludedDays.add("0602");
        excludedDays.add("0815");
        excludedDays.add("1101");
        excludedDays.add("1208");
        excludedDays.add("1225");
        excludedDays.add("1231");
    }

    public int getDailySlot() {
        return dailySlot;
    }

    public void setDailySlot(int dailySlot) {
        this.dailySlot = dailySlot;
    }

    public double getMinDailyTaskSlot() {
        return minDailyTaskSlot;
    }

    public void setMinDailyTaskSlot(double minDailyTaskSlot) {
        this.minDailyTaskSlot = minDailyTaskSlot;
    }

    public boolean isDayOfWeek(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        int curDay = day.getValue();
        return dayOfWeek.indexOf(curDay) != -1;
    }

    public boolean isExcludedDay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        String isoDate = date.format(formatter);
        for (String excluded : excludedDays) {
            if (isoDate.endsWith(excluded)) {
                return true;
            }
        }
        return false;
    }
}
