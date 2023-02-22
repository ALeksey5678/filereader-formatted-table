package com.aleksey5678.filereaderformattedtable.counting;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ConvertedTimeForFinalResult {

    public Map<String, String> convertTimeFromMillisecondsToHours(Map<String, Duration> timeInMillisecondsByAbbreviation) {

        Map<String, String> convertedTimeOfRacingByAbbreviation = new HashMap<>();

        for (Map.Entry<String, Duration> entry : timeInMillisecondsByAbbreviation.entrySet()) {
            String abbreviations = entry.getKey();
             entry.getValue();

            Duration duration =entry.getValue();

            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;
            long milliseconds = duration.toMillis() % 1000;

            String formattedTime = String.format("%02d:%02d.%03d", minutes, seconds, milliseconds);
            convertedTimeOfRacingByAbbreviation.put(abbreviations, formattedTime);
        }

        return convertedTimeOfRacingByAbbreviation;
    }
}
