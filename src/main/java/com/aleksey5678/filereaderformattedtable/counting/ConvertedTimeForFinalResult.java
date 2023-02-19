package com.aleksey5678.filereaderformattedtable.counting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ConvertedTimeForFinalResult {

    public  Map<String, String> convertTimeFromMillisecondsToHours(Map<String, Long> timeInMillisecondsByAbbreviation) {

        Map<String, String> convertedTimeOfRacingByAbbreviation = new HashMap<>();

        for (Map.Entry<String, Long> entry : timeInMillisecondsByAbbreviation.entrySet()) {
            String abbreviations = entry.getKey();
            long timeInMilliseconds = entry.getValue();

            int millisecondsInSecond = 1000;
            int secondsInMinute = 60;
            int minutesInHour = 60;
            int hoursInDay = 24;

            long hours = (timeInMilliseconds / (millisecondsInSecond * secondsInMinute * minutesInHour)) % hoursInDay;
            long minutes = (timeInMilliseconds / (millisecondsInSecond * secondsInMinute)) % minutesInHour;
            long seconds = (timeInMilliseconds / millisecondsInSecond) % secondsInMinute;
            long ms = timeInMilliseconds % millisecondsInSecond;

            Date date = new Date(0, 0, 0, (int) hours, (int) minutes, (int) seconds);
            date.setTime(date.getTime() + ms);
            String formattedDate=new SimpleDateFormat("HH:mm:ss.SSSS").format(date);
            convertedTimeOfRacingByAbbreviation.put(abbreviations, formattedDate);

        }
        return convertedTimeOfRacingByAbbreviation;
    }
}
