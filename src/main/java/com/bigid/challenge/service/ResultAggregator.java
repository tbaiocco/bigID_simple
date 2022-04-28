package com.bigid.challenge.service;

import com.bigid.challenge.repository.ResultResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

public class ResultAggregator {

    private ResultAggregator() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ResultAggregator.class);

    public static void processResults(List<ResultResource> myExecutionResults) {

        logger.info("*** Alphabetical Ordered Results ***************************************************************");
        myExecutionResults.stream()
                .sorted(Comparator.comparing(ResultResource::getName))
                .forEach(result -> logger.info(result.toString()));
        logger.info("*** End of Results *****************************************************************************");

    }
}
