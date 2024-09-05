package com.jabaddon.learning.java.streams;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jabaddon.learning.java.utils.JsonPrinter;

public class TeeingExample {

    public static void main(String[] args) throws IOException {
        List<String> names = List.of("John", "Oliver", "Harry", "Emma", "Sophia", "Lucas", "Ethan");

        Map<Boolean, List<String>> collect = names.stream().collect(Collectors.partitioningBy(name -> name.length() <= 4));
        System.out.println(JsonPrinter.asPrettyJson(collect));

        Long collect2 = names.stream().collect(Collectors.counting());
        System.out.println(JsonPrinter.asPrettyJson(collect2));
        
        Map<String, Object> collect3 = names.stream()
                .collect(Collectors.teeing(
                        Collectors.partitioningBy(name -> name.length() <= 4),
                        Collectors.counting(),
                        (partitions, count) -> {
                            return Map.of(
                                "names with length <= 4", partitions.get(true),
                                "names with length > 4", partitions.get(false),
                                "total names", count
                            );
                        }));
        System.out.println(JsonPrinter.asPrettyJson(collect3));
    }
}
