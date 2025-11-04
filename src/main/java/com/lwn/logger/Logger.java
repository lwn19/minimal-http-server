package com.lwn.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void info(String msg) {
        System.out.println("\u001B[32m][INFO " + now() + "]" + msg + "\u001B[0m]");
    }

    public static void warn(String msg) {
        System.out.println("\u001B[33m][INFO " + now() + "]" + msg + "\u001B[0m]");
    }

    public static void error(String msg) {
        System.out.println("\u001B[31m][INFO " + now() + "]" + msg + "\u001B[0m]");
    }

    private static String now() {
        return LocalDateTime.now().format(fmt);
    }
}
