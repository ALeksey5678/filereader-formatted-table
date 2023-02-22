package com.aleksey5678.filereaderformattedtable.counting;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeSortingTest {
private final TimeSorting timeSorting=new TimeSorting();

    @Test
    void sortedTimeFromSmallestToLargest() {
        Map<String, String> differenceBetweenFinishAndStart = new LinkedHashMap<>();
        differenceBetweenFinishAndStart.put("A", "00:30:00");
        differenceBetweenFinishAndStart.put("B", "00:15:00");
        differenceBetweenFinishAndStart.put("C", "01:00:00");
        differenceBetweenFinishAndStart.put("D", "00:45:00");

        Map<String, String> expectedSortedMap = new LinkedHashMap<>();
        expectedSortedMap.put("B", "00:15:00");
        expectedSortedMap.put("A", "00:30:00");
        expectedSortedMap.put("D", "00:45:00");
        expectedSortedMap.put("C", "01:00:00");

        Map<String, String> sortedMap = timeSorting.sortedTimeFromSmallestToLargest(differenceBetweenFinishAndStart);

        assertEquals(expectedSortedMap, sortedMap);
    }
    }
