package com.jabaddon.testing.readability.primitiveassertions;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CripplingFilePathTest {
    @Test
    void testProductCountBad() {
        File catalogFile = new File("C:\\workspace\\catalog.xml");
        XmlProductCatalog catalog = XmlProductCatalog.parseXmlFrom(catalogFile);
        assertThat(catalog.count(), is(120));
    }

    @Test
    void testProductCount() {
        File catalogFile = new File(getClass().getResource("catalog.xml").getFile());
        XmlProductCatalog catalog = XmlProductCatalog.parseXmlFrom(catalogFile);
        assertThat(catalog.count(), is(120));
    }

    private static class XmlProductCatalog {
        public static XmlProductCatalog parseXmlFrom(File catalogFile) {
            return null;
        }

        public long count() {
            return 0;
        }
    }
}
