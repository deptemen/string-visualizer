package com.example.stringvisualizer.utility;

import java.util.Map;
import java.util.stream.Collectors;

public class LetterCounter {

    public static Map<Character, Integer> countLetters(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLowerCase)
                .collect(Collectors.groupingBy(
                        letter -> letter,
                        Collectors.summingInt(letter -> 1)));
    }
}
