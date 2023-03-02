package com.aleksey5678.filereaderformattedtable.readers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FullNameByAbbreviation {
    public Map<String, Duration> putFullNameOfDriversInsteadOfAbbreviations
            (Map<String, Duration> sortedTimeOfRacingByAbbreviations, Map<String, String> fullNAmeByAbbreviations) {
        Map<String, Duration> timeOfRacingByFullName = new HashMap<>();

        for (Map.Entry<String, Duration> nameAndTime : sortedTimeOfRacingByAbbreviations.entrySet()) {
            String abbreviations = nameAndTime.getKey();
            Duration timeOfRacing = nameAndTime.getValue();
            String fullName = fullNAmeByAbbreviations.get(abbreviations);
            timeOfRacingByFullName.put(fullName, timeOfRacing);
        }
        return timeOfRacingByFullName;
    }
}
