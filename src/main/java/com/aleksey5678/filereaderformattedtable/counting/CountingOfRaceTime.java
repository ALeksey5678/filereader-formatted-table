package com.aleksey5678.filereaderformattedtable.counting;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountingOfRaceTime {
    public Map<String, Duration> countRaceTime(Map<String, Date> start, Map<String, Date> finish) {
        Map<String, Duration> timeInMillisecondsByAbbreviation = new HashMap<>();
        for (String key : start.keySet()) {
            Date date1 = start.get(key);
            Date date2 = finish.get(key);
           Duration duration=Duration.between(date1.toInstant(), date2.toInstant());
           timeInMillisecondsByAbbreviation.put(key,duration);
        }
        return timeInMillisecondsByAbbreviation;
    }
}
