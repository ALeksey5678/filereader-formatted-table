package com.aleksey5678.filereaderformattedtable.counting;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountingOfRaceTime {
    public Map<String, Long> countRaceTime(Map<String, Date> start, Map<String, Date> finish) {
        Map<String, Long> timeInMillisecondsByAbbreviation = new HashMap<>();
        for (String key : start.keySet()) {
            Date date1 = start.get(key);
            Date date2 = finish.get(key);
            long differenceBetweenFinishAndStart = date2.getTime() - date1.getTime();
            timeInMillisecondsByAbbreviation.put(key, differenceBetweenFinishAndStart);
        }
        return timeInMillisecondsByAbbreviation;
    }
}
