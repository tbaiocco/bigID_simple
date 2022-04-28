package com.bigid.challenge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfoUtils {

    private static final Logger logger = LoggerFactory.getLogger(InfoUtils.class);

    private InfoUtils() {
    }

    public static void logMemoryOnInit() {
        logger.info("Max Memory: {} Mb", Runtime.getRuntime()
                .maxMemory() / 1048576);
        logger.info("Total Memory: {} Mb", Runtime.getRuntime()
                .totalMemory() / 1048576);
        logger.info("Free Memory: {} Mb", Runtime.getRuntime()
                .freeMemory() / 1048576);
    }

    public static void logFreeMemoryStatus() {
        logger.info("Free Memory: {} Mb", Runtime.getRuntime()
                .freeMemory() / 1048576);
    }
}
