package com.aleksey5678.filereaderformattedtable.counting;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingOfRaceTimeTest {
    private final CountingOfRaceTime countingOfRaceTime = new CountingOfRaceTime();

    private final static int MILLIS = 18;

    @Test
    void shouldCountTimeOfRacingInMillis() {
        Map<String, Date> inputStart = new HashMap<>();
        Map<String, Date> inputFinish = new HashMap<>();

        inputStart.put("A", new Date(111111100L));
        inputFinish.put("A", new Date(111111118L));

        Map<String, Duration> actual = countingOfRaceTime.countRaceTime(inputStart, inputFinish);

        assertEquals(Duration.ofMillis(MILLIS), actual.get("A"));
    }
}