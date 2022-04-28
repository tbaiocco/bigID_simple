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

public class ReadMatchAggregateApp {

    public static final String[] COMMON_NAMES = {"James", "John", "Robert", "Michael", "William", "David", "Richard",
            "Charles", "Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth",
            "Steven", "Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy", "Jose",
            "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond", "Gregory", "Joshua", "Jerry",
            "Dennis", "Walter", "Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl", "Arthur", "Ryan", "Roger"};
    public static final String FILEPATH = "http://norvig.com/big.txt";
    public static final ResultRepositoryInMemory repository = new ResultRepositoryInMemory();
    private static final Logger logger = LoggerFactory.getLogger(ReadMatchAggregateApp.class);

    public static void main(String[] args) {

        logger.info("*** Starting processing file: {}", FILEPATH);
        InfoUtils.logMemoryOnInit();
        try {
            List<String> linesRead = FileReader.readFile(FILEPATH);
            TextMatcher.processLinesInParallel(linesRead);
            ResultAggregator.processResults(repository.getAll());
        } catch (IOException e) {
            logger.error("Error on URL or contents:", e);
        }
        InfoUtils.logFreeMemoryStatus();
        logger.info("*** Execution Finished!");
    }

}