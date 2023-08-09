package com.example.stringvisualizer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StringVisualizerServiceTest {
        @Autowired
        private StringVisualizerService stringVisualizerService;

        @Test
        void testStringVisualizer() {
            String s1 = "my&friend&Paul has heavy hats! &";
            String s2 = "my friend John has many many friends &";
            String expectedOutput ="2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss";

            String result = stringVisualizerService.computeMaxLetterOccurrence(s1, s2);
            assertNotNull(result);
            assertEquals(expectedOutput,result);
        }

    @Test
    void testStringVisualizerForUpperCase() {
        String s1 = "ADFTS@*";
        String s2 = "JFHEO#@";
        String expectedOutput ="Please provide valid inputs to compare";

        String result = stringVisualizerService.computeMaxLetterOccurrence(s1, s2);
        assertNotNull(result);
        assertEquals(expectedOutput,result);
    }
    }


