package com.aleksey5678.filereaderformattedtable.readers;

import java.util.HashMap;
import java.util.Map;

public class FullNameByAbbreviation {
    public Map<String, Long> putFullNameOfDriversInsteadOfAbbreviations(Map<String, Long> sortedTimeOfRacingByAbbreviations,
                                                                        Map<String, String> fullNAmeByAbbreviations) {
        Map<String, Long> timeOfRacingByFullName = new HashMap<>();
        for (String key : sortedTimeOfRacingByAbbreviations.keySet()) {
            String newKey = fullNAmeByAbbreviations.get(key);
            timeOfRacingByFullName.put(newKey, sortedTimeOfRacingByAbbreviations.get(key));
        }
        return timeOfRacingByFullName;
    }
}
