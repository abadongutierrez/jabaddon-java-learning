package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class FlakyTest {
    private File logDirectory = new File("./dir");

    private static final int TEN_SECS = 10;
    private AtomicLong fileTimestamp = new AtomicLong(System.currentTimeMillis());

    @Test
    void testAggregatedLogSortedByTimestamp() {
        generateLogFile(logDirectory, "log-01.txt", "one");
        generateLogFile(logDirectory, "log-02.txt", "two", "three");
        generateLogFile(logDirectory, "log.txt", "four", "five", "six");
        AggregatedLog aggregatedLog = AggregatedLog.fromDirectory(logDirectory);
        assertThat(aggregatedLog.lines(), contains("one", "two", "three", "four", "five", "six"));
    }

    private void generateLogFile(File logDirectory, String fileName, String... lines) {
        File file = new File(logDirectory, fileName);
        FileUtils.writeLines(file, lines);
        file.setLastModified(fileTimestamp.addAndGet(TEN_SECS));
    }

    private static class AggregatedLog {
        public static AggregatedLog fromDirectory(File logDirectory) {
            return null;
        }

        public List<String> lines() {
            return null;
        }
    }

    private static class FileUtils {
        public static void writeLines(File file, String[] lines) {
        }
    }
}
