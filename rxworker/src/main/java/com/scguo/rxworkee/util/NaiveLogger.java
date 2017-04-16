package com.scguo.rxworkee.util;

/**
 * A simple state of which monitoring the output from terminal
 */
public class NaiveLogger {
    private NaiveLogger() {
    }

    public static void log(String msg) {
        System.out.println(msg);
    }

}
