package com.bigid.challenge.service;

import com.bigid.challenge.ReadMatchAggregateApp;
import com.bigid.challenge.repository.ResultNameOccurrence;
import com.bigid.challenge.repository.ResultResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bigid.challenge.ReadMatchAggregateApp.COMMON_NAMES;

public class TextMatcher {

    private static final Logger logger = LoggerFactory.getLogger(TextMatcher.class);
    private static final Set<String> threadsUsed = new HashSet<>();

    private TextMatcher() {
    }

    public static void processLinesInParallel(List<String> linesRead) {

        Arrays.stream(COMMON_NAMES).parallel().forEach(name -> matchNames(name, linesRead));
        logger.info("Threads used on matchers: {} ", threadsUsed.size());
    }

    private static void matchNames(String name, List<String> linesRead) {
        ResultResource resultByName = TextMatcher.findNameInLines(linesRead, name);
        ReadMatchAggregateApp.repository.addResult(resultByName);
        threadsUsed.add(String.valueOf(Thread.currentThread().getId()));
        logger.debug("Running on thread {}: results for [{}] are <{}>", Thread.currentThread().getId(), name, resultByName);
    }

    private static ResultResource findNameInLines(List<String> lines, String name) {

        List<ResultNameOccurrence> occurrences = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            int lineNumber = i + 1;
            findWordInText(lines.get(i), name).forEach(idx ->
                    occurrences.add(new ResultNameOccurrence.Builder(lineNumber, idx + 1L).build())
            );

        }

        return new ResultResource.Builder(name).occurrences(occurrences).build();
    }

    private static List<Integer> findWordInText(String textString, String word) {
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
