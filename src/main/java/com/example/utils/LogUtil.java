package com.example.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    private static final int MAX_LINES = 25;

    public static void exception(Exception e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getMessage()).append(" ").append(e.getClass()).append("\n");
        for (int i = 0; i < e.getStackTrace().length && i < MAX_LINES; ++i) {
            stringBuilder.append(e.getStackTrace()[i]).append("\n");
        }
        log.info("Exception: " + stringBuilder);
        log.error("Exception: " + stringBuilder);
    }

    public static void exception(Exception e, String methodName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getMessage()).append(" ").append(e.getClass()).append("\n");
        for (int i = 0; i < e.getStackTrace().length && i < MAX_LINES; ++i) {
            stringBuilder.append(e.getStackTrace()[i]).append("\n");
        }
        log.info("Method " + methodName + " Exception: " + stringBuilder);
        log.error("Method " + methodName + " Exception: " + stringBuilder);
    }

    public static void throwable(Throwable e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getMessage()).append(" ").append(e.getClass()).append("\n");
        for (int i = 0; i < e.getStackTrace().length && i < MAX_LINES; ++i) {
            stringBuilder.append(e.getStackTrace()[i]).append("\n");
        }
        log.info("Throwable: " + stringBuilder);
        log.error("Throwable: " + stringBuilder);
    }
}
