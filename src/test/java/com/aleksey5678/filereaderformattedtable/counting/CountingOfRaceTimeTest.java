package com.aleksey5678.filereaderformattedtable.counting;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingOfRaceTimeTest {
 private final CountingOfRaceTime countingOfRaceTime=new CountingOfRaceTime();
    @Test
    void countRaceTime() {
        Map<String,Date>inputStart=new HashMap<>();
        Map<String,Date>inputFinish=new HashMap<>();

        inputStart.put("A", new Date(11111110L));
        inputFinish.put("A",new Date(11111111L));

        Map<String,Duration>actual=countingOfRaceTime.countRaceTime(inputStart,inputFinish);

        assertEquals(Duration.ofMillis(001),actual.get("A"));
    }
}