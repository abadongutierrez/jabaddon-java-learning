package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncidentalDetailsTest {
    private Classifier classifier = new Classifier();
    private List<Item> storedTypeA = new ArrayList<>();

    @BeforeEach
    void setup() {
        classifier = new Classifier();
        storedTypeA = createItemsOfType(4, ItemType.TYPE_A);
        addItemsToClassifier(classifier, storedTypeA);
        addItemsToClassifier(classifier, createItemsOfType(2, ItemType.TYPE_B));
    }

    @Test
    void testClassifier() {
        List<Item> items = classifier.getItemsFromType(ItemType.TYPE_A);
        assertTrue(items.size() == storedTypeA.size());
        for (Item item : items) {
            assertTrue(storedTypeA.contains(item));
        }
    }

    @Test
    void testClassifier2() {
        assertThat(classifier.getItemsFromType(ItemType.TYPE_A), contains(storedTypeA));
    }

    private void addItemsToClassifier(Classifier classifier, List<Item> itemsOfType) {
    }

    private List<Item> createItemsOfType(int i, Object typeA) {
        return null;
    }

    private class Classifier {
        public void addItem(Item abc1) {
        }

        public List<Item> getItemsFromType(Object typeA) {
            return null;
        }
    }

    private class Item {
        public Item(String abc1, Object typeA) {
        }
    }

    private class ItemType {
        public static final Object TYPE_A = "";
        public static final Object TYPE_B = "";
    }
}
