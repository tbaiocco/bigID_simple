package com.bigid.challenge.service;

import com.bigid.challenge.utils.InfoUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private FileReader() {
    }

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    public static List<String> readFile(String filepath) throws IOException {
        final URL path = new URL(filepath);

        long linesCounter = 0;

        File tempFile = new File(System.currentTimeMillis()+".txt");
        FileUtils.copyURLToFile(path, tempFile);
        logger.info("File size: {} bytes", tempFile.length());
        List<String> lines = new ArrayList<>();

        try (final LineIterator it = FileUtils.lineIterator(tempFile, StandardCharsets.US_ASCII.displayName())) {

            while (it.hasNext()) {
                linesCounter++;
                lines.add(it.nextLine());
            }

        } catch (IOException e) {
            logger.info("Expecting file to be closed: {}", e.getMessage());
        } finally {
            Files.delete(tempFile.toPath());
        }
        logger.info("Lines read: {} | Lines mapped: {} | Temp file deleted.",
                linesCounter,
                lines.size());

        InfoUtils.logFreeMemoryStatus();

        return lines;
    }
}
