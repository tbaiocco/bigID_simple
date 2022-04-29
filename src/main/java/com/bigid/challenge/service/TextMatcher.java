package com.bigid.challenge.service;

import com.bigid.challenge.ReadMatchAggregateApp;
import com.bigid.challenge.repository.LineResource;
import com.bigid.challenge.repository.ResultNameOccurrence;
import com.bigid.challenge.repository.ResultResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMatcher {

    public static final String[] COMMON_NAMES = {"James", "John", "Robert", "Michael", "William", "David", "Richard",
            "Charles", "Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth",
            "Steven", "Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy", "Jose",
            "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond", "Gregory", "Joshua", "Jerry",
            "Dennis", "Walter", "Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl", "Arthur", "Ryan", "Roger"};
    private static final Logger logger = LoggerFactory.getLogger(TextMatcher.class);
    private static final Set<String> threadsUsed = new HashSet<>();

    private TextMatcher() {
    }

    public static void prepareAndProcessFileChunks(Map<Integer, List<String>> mappedChunk, Integer k, int chunkSize) {
        List<LineResource> preparedLineChunks = new ArrayList<>();
        for (int i = 0; i < mappedChunk.get(k).size(); i++) {
            long lineNumber = i + 1L;
            preparedLineChunks.add(new LineResource.Builder(lineNumber + ((long) k * chunkSize), mappedChunk.get(k).get(i)).build());
        }
        processLinesInParallel(preparedLineChunks);
    }

    private static void processLinesInParallel(List<LineResource> linesRead) {

        Arrays.stream(COMMON_NAMES).parallel().forEach(name -> runMatcherForGivenWordAndCollectResult(name, linesRead));
        logger.debug("Threads used on matchers: {} ", threadsUsed.size());
    }

    private static void runMatcherForGivenWordAndCollectResult(String name, List<LineResource> linesRead) {
        ResultResource resultByName = TextMatcher.findAllOccurrencesOfWordInLinesList(linesRead, name);
        ReadMatchAggregateApp.repository.addResult(resultByName);
        threadsUsed.add(String.valueOf(Thread.currentThread().getId()));
        logger.debug("Running on thread {}: results for [{}] are <{}>", Thread.currentThread().getId(), name, resultByName);
    }

    private static ResultResource findAllOccurrencesOfWordInLinesList(List<LineResource> lines, String name) {

        List<ResultNameOccurrence> occurrences = new ArrayList<>();
        lines.forEach(lineResource ->
                returnIndexesOfWordInLineContent(lineResource.getLineContent(), name).forEach(idx ->
                        occurrences.add(new ResultNameOccurrence.Builder(lineResource.getLineOffset(), idx + 1L).build())
                )
        );

        return new ResultResource.Builder(name).occurrences(occurrences).build();
    }

    private static List<Integer> returnIndexesOfWordInLineContent(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();
        int wordLength = 0;

        int index = 0;
        while (index != -1) {
            index = indexOfWholeWord(word, textString, index + wordLength);
            if (index != -1) {
                indexes.add(index);
            }
            wordLength = word.length();
        }
        return indexes;
    }

    public static int indexOfWholeWord(String regex, String s, int index) {
        Pattern pattern = Pattern.compile("\\b" + regex + "\\b");
        Matcher matcher = pattern.matcher(s);
        return matcher.find(index) ? matcher.start() : -1;
    }
}
