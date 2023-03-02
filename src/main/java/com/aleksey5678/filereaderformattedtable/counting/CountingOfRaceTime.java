package com.aleksey5678.filereaderformattedtable.counting;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountingOfRaceTime {
    public Map<String, Duration> countRaceTime(Map<String, Date> start, Map<String, Date> finish) {
        Map<String, Duration> timeInMillisecondsByAbbreviation = new HashMap<>();

        for (Map.Entry<String, Date> nameAndTime : start.entrySet()) {
            String abbreviation = nameAndTime.getKey();
            Date startDate = nameAndTime.getValue();
            Date finishDate = finish.get(abbreviation);
            Duration timeOfRacingInMilliseconds = Duration.between(startDate.toInstant(), finishDate.toInstant());
            timeInMillisecondsByAbbreviation.put(abbreviation, timeOfRacingInMilliseconds);
        }
        return timeInMillisecondsByAbbreviation;
    }
}
