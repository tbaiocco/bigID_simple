package com.bigid.challenge;

import com.bigid.challenge.repository.ResultRepositoryInMemory;
import com.bigid.challenge.service.FileReader;
import com.bigid.challenge.service.ResultAggregator;
import com.bigid.challenge.service.TextMatcher;
import com.bigid.challenge.utils.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadMatchAggregateApp {

    public static final String FILEPATH = "http://norvig.com/big.txt";
    public static final ResultRepositoryInMemory repository = new ResultRepositoryInMemory();
    private static final int CHUNK_SIZE = 1000;
    private static final Logger logger = LoggerFactory.getLogger(ReadMatchAggregateApp.class);

    public static void main(String[] args) {

        logger.info("*** Starting processing file: {}", FILEPATH);
        InfoUtils.logMemoryOnInit();
        try {

            Map<Integer, List<String>> mappedChunk = FileReader.readFileInChunks(FILEPATH, CHUNK_SIZE);

            mappedChunk.keySet().forEach(k -> TextMatcher.prepareAndProcessFileChunks(mappedChunk, k, CHUNK_SIZE));

            ResultAggregator.aggregateResults(repository.getAll());
        } catch (IOException e) {
            logger.error("Error on URL or contents:", e);
        }
        InfoUtils.logFreeMemoryStatus();
        logger.info("*** Execution Finished!");
    }

}
