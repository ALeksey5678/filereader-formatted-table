package com.aleksey5678.filereaderformattedtable.counting;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConvertedTimeForFinalResultTest {
    private final  ConvertedTimeForFinalResult convertedTimeForFinalResult=new ConvertedTimeForFinalResult();

    @Test
    public void testConvertTimeFromMillisecondsToHours() {
        Map<String, Long> input = new HashMap<>();
        input.put("A", 900000L);
        input.put("N", 0L);

        Map<String, String> output = convertedTimeForFinalResult.convertTimeFromMillisecondsToHours(input);

        assertEquals("15:00.000", output.get("A"));
        assertEquals("00:00.000", output.get("N"));
    }
    }

