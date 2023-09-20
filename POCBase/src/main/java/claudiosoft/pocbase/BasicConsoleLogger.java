/**
 * MIT License - 2021
 */
package claudiosoft.pocbase;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A really simple logging wrapper. Aimed to print to console (stdout) only
 */
public class BasicConsoleLogger {

    static {
        // console logger formatting: 2020-04-04 19:42:45 INFO - msg
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS - %5$s%6$s%n");
    }

    /**
     * Three supported log level
     */
    public enum LogLevel {
        NONE,
        NORMAL,
        DEBUG
    }
    private static Logger internalLogger = null;
    private LogLevel level = LogLevel.NORMAL;

    private static BasicConsoleLogger logger;

    public static BasicConsoleLogger get() {
        return get(LogLevel.NORMAL);
    }

    public static BasicConsoleLogger get(LogLevel level) {
        return get(level, "Logger");
    }

    public static BasicConsoleLogger get(LogLevel level, String logName) {
        if (logger == null) {
            logger = new BasicConsoleLogger(level, logName);
        }
        return logger;
    }

    private BasicConsoleLogger(LogLevel level, String logName) {
        internalLogger = Logger.getLogger(logName);
        Handler handlerObj = new ConsoleHandler();

        switch (level) {
            case DEBUG:
                handlerObj.setLevel(Level.ALL);
                internalLogger.setLevel(Level.ALL);
                break;
            case NORMAL:
                handlerObj.setLevel(Level.INFO);
                internalLogger.setLevel(Level.INFO);
                break;
            default:
                handlerObj.setLevel(Level.OFF);
                internalLogger.setLevel(Level.OFF);
                break;
        }
        internalLogger.addHandler(handlerObj);
        internalLogger.setUseParentHandlers(false);
        this.level = level;
    }

    public void info(String message) {
        internalLogger.log(Level.INFO, "[INFO] {0}", message);
    }

    public void error(String message) {
        error(message, null);
    }

    public void error(String message, Exception ex) {
        if (ex != null) {
            internalLogger.log(Level.SEVERE, "[SEVERE] " + message, ex);
        } else {
            internalLogger.log(Level.SEVERE, "[SEVERE] {0}", message);
        }
    }

    public void debug(String message) {
        if (level == LogLevel.DEBUG) {
            internalLogger.log(Level.INFO, "[DEBUG] {0}", message);
        }
    }
}
