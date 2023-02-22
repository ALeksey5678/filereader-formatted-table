package com.aleksey5678.filereaderformattedtable.readers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FullNameByAbbreviation {
    public Map<String, Duration> putFullNameOfDriversInsteadOfAbbreviations(Map<String, Duration> sortedTimeOfRacingByAbbreviations,
                                                                            Map<String, String> fullNAmeByAbbreviations) {
        Map<String, Duration> timeOfRacingByFullName = new HashMap<>();
        for (String key : sortedTimeOfRacingByAbbreviations.keySet()) {
            String newKey = fullNAmeByAbbreviations.get(key);
            timeOfRacingByFullName.put(newKey, sortedTimeOfRacingByAbbreviations.get(key));
        }
        return timeOfRacingByFullName;
    }
}
