package com.bigid.challenge.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    private FileReader() {
    }

    public static Map<Integer, List<String>> readFileInChunks(String filepath, int chunkSize) throws IOException {
        final URL url = new URL(filepath);

        File tempFile = new File(System.currentTimeMillis() + ".txt");
        FileUtils.copyURLToFile(url, tempFile);
        logger.info("File size: {} bytes", tempFile.length());

        Path path = Path.of(tempFile.getPath());
        final AtomicInteger c = new AtomicInteger();

        try (Stream<String> lineStream = Files.lines(path)) {
            return lineStream.collect(Collectors.groupingBy(e -> c.getAndIncrement() / chunkSize));
        } finally {
            Files.delete(tempFile.toPath());
        }

    }
}
