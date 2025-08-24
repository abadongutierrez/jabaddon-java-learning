package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class SimpleArrayListExample {
    public static void main(String[] args) {
        List<String> emojis = new ArrayList<>();
        emojis.add("\uD83D\uDE00");
        emojis.add("\uD83D\uDE01");
        emojis.add("\uD83D\uDE02");
        System.out.println("emojis = " + emojis);


        SequencedCollection<String> sequencedCollection = emojis;
        SequencedCollection<String> reversed = sequencedCollection.reversed();
        System.out.println("reversed = " + reversed);

        sequencedCollection.addFirst("Emojis:");
        System.out.println("sequencedCollection = " + sequencedCollection);
    }
}
