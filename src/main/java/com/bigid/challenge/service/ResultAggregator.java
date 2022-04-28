package com.bigid.challenge.service;

import com.bigid.challenge.repository.ResultResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultAggregator {

    private ResultAggregator() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ResultAggregator.class);

    public static void processResults(List<ResultResource> myExecutionResults) {

        logger.info("*** Alphabetical Ordered Results ***************************************************************");
        Map<String, List<ResultResource>> resultMap = myExecutionResults.stream()
                .collect(Collectors.groupingBy(ResultResource::getName));
        List<ResultResource> flat = new ArrayList<>();
        resultMap.keySet().forEach(k -> {
            ResultResource flatObj = new ResultResource.Builder(k).build();
            resultMap.get(k).forEach(resultResource -> flatObj.appendOccurrences(resultResource.getOccurrences()));
            flat.add(flatObj);
        });
        flat.stream()
                .sorted(Comparator.comparing(ResultResource::getName))
                .forEach(result -> logger.info(result.toString()));
        logger.info("*** End of Results *****************************************************************************");

    }
}
