package com.example.stringvisualizer.service;

import com.example.stringvisualizer.utility.LetterCounter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class StringVisualizerService {

    public String computeMaxLetterOccurrence(String s1, String s2) {
        Map<Character, Integer> freq1 = LetterCounter.countLetters(s1);
        Map<Character, Integer> freq2 = LetterCounter.countLetters(s2);

        List<String> resultList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : freq1.entrySet()) {
            char letter = entry.getKey();
            if (freq2.containsKey(letter)) {
                int maxOccurrence = Math.max(entry.getValue(), freq2.get(letter));
                if (maxOccurrence > 1) {
                    String prefix = freq1.get(letter) == maxOccurrence && freq2.get(letter) == maxOccurrence ? "=:" :
                            freq1.get(letter) == maxOccurrence ? "1:" : "2:";
                    resultList.add(prefix + String.valueOf(letter).repeat(maxOccurrence));
                }
            }
        }

        resultList.sort(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder()));

        return resultList.size() > 0 ? String.join("/", resultList) : "Please provide valid inputs to compare";
    }


}
