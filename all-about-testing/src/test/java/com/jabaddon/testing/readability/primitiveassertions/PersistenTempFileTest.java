package com.jabaddon.testing.readability.primitiveassertions;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersistenTempFileTest {
    private File tempFile;

    @BeforeEach
    void setup() {
        tempFile = new File(System.getProperty("java.io.tmdir"), "catalog.xml");
    }

    @Test
    void testEmptyCatalog() {
        populateFileWithProducts(0);
        XmlProductCatalog xmlProductCatalog = XmlProductCatalog.parseFromFile(tempFile);
        assertThat(xmlProductCatalog.countProducts(), is(0));
    }

    @Test
    void testWhenFileDoesNotExist() {
        withMissingFile();
        XmlProductCatalog xmlProductCatalog = XmlProductCatalog.parseFromFile(tempFile);
        assertThat(xmlProductCatalog.countProducts(), is(0));
    }

    private void withMissingFile() {
        tempFile.delete();
    }

    private void populateFileWithProducts(int i) {

    }

    private static class XmlProductCatalog {
        public static XmlProductCatalog parseFromFile(File tempFile) {
            return null;
        }

        public String countProducts() {
            return null;
        }
    }
}
