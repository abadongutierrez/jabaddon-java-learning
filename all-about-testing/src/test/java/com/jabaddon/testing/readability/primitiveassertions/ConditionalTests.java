package com.jabaddon.testing.readability.primitiveassertions;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ConditionalTests {
    @Test
    void listingFilesBad() {
        String[] files = {"file01.txt", "image.png", "document.doc"};
        File dir = createTempDirWithFiles(files);
        String[] cmd = new String[] { "ls", "-1", dir.getAbsolutePath() };
        SystemProcess process = new SystemProcess(cmd).runAndWait();
        if (process.exitCode() == 0) {
            assertThat(Stream.of(process.output().split("\n")).collect(Collectors.toList()),
                    containsInAnyOrder(files));
        }
    }

    @Test
    void listingFiles() {
        String[] files = {"file01.txt", "image.png", "document.doc"};
        File dir = createTempDirWithFiles(files);
        String[] cmd = new String[] { "ls", "-1", dir.getAbsolutePath() };
        SystemProcess process = new SystemProcess(cmd).runAndWait();
        assumeTrue(process.exitCode() == 0, "SystemProcess exitCode is not success");
        // or assertThat(process.exitCode(), is(0));
        assertThat(Stream.of(process.output().split("\n")).collect(Collectors.toList()),
                containsInAnyOrder(files));

    }

    private static class SystemProcess {

        public SystemProcess(String[] cmd) {

        }

        public SystemProcess runAndWait() {
            return new SystemProcess(new String[]{});
        }

        public int exitCode() {
            return 1;
        }

        public String output() {
            return "file01.txt\nimage.png\ndocument.doc";
        }
    }

    private File createTempDirWithFiles(String... files) {
        return new File("");
    }
}
