package com.jabaddon.learning.java;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ComposingFunctionsExample {
    private enum Case { EVEN, ODD };
    public static void main(String[] args) {
        List<String> values = List.of("hi", "there", "how", "are", "you");
        Function<String, String> toUpperCaseFunction = (v) -> v.toUpperCase();
        Function<String, String> functionEven = toOtherCaseWhen(Case.EVEN);
        Function<String, String> functionOdd = toOtherCaseWhen(Case.ODD);
        Function<String, String> functionVowelToNum = toVowelNumber();

        System.out.println(values);
        System.out.println(values.stream().map(functionEven).toList());
        System.out.println(values.stream().map(functionOdd).toList());
        System.out.println(values.stream().map(
                toUpperCaseFunction.compose(functionEven)).toList());
        System.out.println(values.stream().map(
                functionEven.compose(toUpperCaseFunction)).toList());
        System.out.println(values.stream().map(
                functionVowelToNum.andThen(functionOdd)).toList());

        Function<Integer, Integer> addOne = (x) -> x + 1;
        Function<Integer, Integer> byTwo = (x) -> x * 2;
        Function<Integer, Integer> minusOne = (x) -> x - 1;

        // 2 |> byTwo |> addOne
        System.out.println(addOne.compose(byTwo).apply(2));
        // 2 |> addOne |> byTwo
        System.out.println(byTwo.compose(addOne).apply(2));
        // 2 |> addOne |> minusOne
        System.out.println(addOne.andThen(minusOne).apply(2));
    }

    private static Function<String, String> toVowelNumber() {
        Map<Character, Character> numberPerVowel =
                Map.of('a', '4', 'A', '4',
                        'e', '3', 'E', '3',
                        'i', '1', 'I', '1',
                        'o', '0', 'O', '0',
                        'u', '7', 'U', '7');
        return (String v) -> {
            char[] array = v.toCharArray();
            char[] newArray = new char[array.length];
            for (int i = 0; i < array.length; ++i) {
                if (numberPerVowel.containsKey(array[i])) {
                    newArray[i] = numberPerVowel.get(array[i]);
                } else {
                    newArray[i] = array[i];
                }
            }
            return new String(newArray);
        };
    }

    private static Function<String, String> toOtherCaseWhen(Case whenCase) {
        Function<Character, Character> invertCase = (c) ->
                Character.isUpperCase(c) ?
                        Character.toLowerCase(c) : Character.toUpperCase(c);

        return (String v) -> {
            char[] array = v.toCharArray();
            char[] newArray = new char[array.length];
            for (int i = 0; i < array.length; i++) {
                if (whenCase == Case.EVEN && i % 2 == 0) {
                    newArray[i] = invertCase.apply(array[i]);
                } else if (whenCase == Case.ODD && i % 2 != 0) {
                    newArray[i] = invertCase.apply(array[i]);
                } else {
                    newArray[i] = array[i];
                }
            }
            return new String(newArray);
        };
    }
}
