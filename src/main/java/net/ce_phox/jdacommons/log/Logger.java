package net.ce_phox.jdacommons.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public static void info(String message) {
        System.out.println(new SimpleDateFormat("[HH:mm:ss]").format(new Date()) + " [INFO] " + message);
    }

    public static void warning(String message) {
        System.out.println(new SimpleDateFormat("[HH:mm:ss]").format(new Date()) + " [WARNING] " + message);
    }

    public static void error(String message) {
        System.err.println(new SimpleDateFormat("[HH:mm:ss]").format(new Date()) + " [ERROR] " + message + "!");
    }

    public static void debug(String message) {
        System.out.println(new SimpleDateFormat("[HH:mm:ss]").format(new Date()) + " [DEBUG] " + message);
    }

    public static void formated(String message, Object... args) {
        System.out.printf(new SimpleDateFormat("[HH:mm:ss]").format(new Date()) + " [INFO] " + message, args);
    }
}
