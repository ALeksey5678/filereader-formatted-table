package com.aleksey5678.filereaderformattedtable.counting;

import java.util.LinkedHashMap;
import java.util.Map;

public class TimeSorting {
    public Map<String, String> sortedTimeFromSmallestToLargest(Map<String, String> differenceBetweenFinishAndStart) {
        Map<String, String> sortedMap = new LinkedHashMap<>();
        differenceBetweenFinishAndStart.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }
}
