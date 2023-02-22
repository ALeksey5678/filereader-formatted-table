package com.aleksey5678.filereaderformattedtable.counting;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConvertedTimeForFinalResultTest {

    private final ConvertedTimeForFinalResult convertedTimeForFinalResult = new ConvertedTimeForFinalResult();


    @Test
    public void testConvertTimeFromMillisecondsToHours() {
        Map<String, Duration> input = new HashMap<>();
        input.put("A", Duration.ofMillis(100));
        input.put("N", Duration.ofMinutes(10).plusSeconds(10));

        Map<String, String> output = convertedTimeForFinalResult.convertTimeFromMillisecondsToHours(input);

        assertEquals("00:00.100", output.get("A"));
        assertEquals("10:10.000", output.get("N"));
    }
}

