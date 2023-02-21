package com.aleksey5678.filereaderformattedtable.starter;

import com.aleksey5678.filereaderformattedtable.counting.ConvertedTimeForFinalResult;
import com.aleksey5678.filereaderformattedtable.readers.FromStringToDate;
import com.aleksey5678.filereaderformattedtable.readers.MapFormList;
import com.aleksey5678.filereaderformattedtable.readers.StartLogByStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Starter {
    public static void main(String[] args) throws IOException {
        Starter starter = new Starter();
        StartLogByStreams startLogByStreams = new StartLogByStreams();
        MapFormList mapFormList = new MapFormList();
        FromStringToDate fromStringToDate = new FromStringToDate();
        ConvertedTimeForFinalResult convertedTimeForFinalResult = new ConvertedTimeForFinalResult();
        TableFormat tableFormat=new TableFormat();

        List<String> readFromStarter = startLogByStreams.readFromStarter("src/main/resources/start.log");
        List<String> readFromFinish = startLogByStreams.readFromStarter("src/main/resources/end.log");
        List<String> readFromAbbreviations = startLogByStreams.readFromStarter("src/main/resources/abbreviations.txt");


        Map<String, Date> DateOfStartByName =
                fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromStarter));
        Map<String, Date> DateOfFinishByName =
                fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromFinish));
        Map<String, Long> timeOfRaceByKey = starter.countRaceTime(DateOfStartByName, DateOfFinishByName);
        Map<String, String> fullNameByAbbreviation = mapFormList.getMapFromList(readFromAbbreviations);
        Map<String, Long> timeOfRacingByFullNameOfDrivers =
                starter.putFullNameOfDriversInsteadOfAbbreviations(timeOfRaceByKey, fullNameByAbbreviation);
        Map<String,String> timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers =
                convertedTimeForFinalResult.convertTimeFromMillisecondsToHours(timeOfRacingByFullNameOfDrivers);
        Map<String, String> sortedTimeOfRacingByFullName = starter.sortedTimeFromSmallestToLargest(timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers);
        //System.out.println(starter.sortedTimeFromSmallestToLargest(timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers));
       // System.out.println(timeOfRacingByFullNameOfDrivers);
       // System.out.println(starter.buildTableFromMap(timeOfRacingByFullNameOfDrivers));
      //  System.out.println(timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers);
        tableFormat.buildTheTableForOutputTheResult(sortedTimeOfRacingByFullName);
    }

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

    public Map<String, String> sortedTimeFromSmallestToLargest(Map<String, String> differenceBetweenFinishAndStart) {
        Map<String, String> sortedMap = new LinkedHashMap<>();
        differenceBetweenFinishAndStart.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }


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

