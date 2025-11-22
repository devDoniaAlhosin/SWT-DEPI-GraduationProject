package utils;

import java.util.logging.Logger;

public class LogUtil {

    private static final Logger logger = Logger.getLogger(LogUtil.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.severe(message);
    }
}
