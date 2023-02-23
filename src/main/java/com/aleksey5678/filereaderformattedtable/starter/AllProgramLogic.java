package com.aleksey5678.filereaderformattedtable.starter;

import com.aleksey5678.filereaderformattedtable.counting.ConvertedTimeForFinalResult;
import com.aleksey5678.filereaderformattedtable.counting.CountingOfRaceTime;
import com.aleksey5678.filereaderformattedtable.counting.TimeSorting;
import com.aleksey5678.filereaderformattedtable.readers.FromStringToDate;
import com.aleksey5678.filereaderformattedtable.readers.FullNameByAbbreviation;
import com.aleksey5678.filereaderformattedtable.readers.MapFormList;
import com.aleksey5678.filereaderformattedtable.readers.StartLogByStreams;
import com.aleksey5678.filereaderformattedtable.table.TableFormat;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AllProgramLogic {
    public String returnTableWithOutput(){
        StartLogByStreams startLogByStreams = new StartLogByStreams();
        MapFormList mapFormList = new MapFormList();
        FromStringToDate fromStringToDate = new FromStringToDate();
        ConvertedTimeForFinalResult convertedTimeForFinalResult = new ConvertedTimeForFinalResult();
        TableFormat tableFormat=new TableFormat();
        CountingOfRaceTime countingOfRaceTime=new CountingOfRaceTime();
        TimeSorting timeSorting=new TimeSorting();
        FullNameByAbbreviation fullNameByAbbreviationObj=new FullNameByAbbreviation();

        List<String> readFromStarter = startLogByStreams.readFromStarter("src/main/resources/start.log");
        List<String> readFromFinish = startLogByStreams.readFromStarter("src/main/resources/end.log");
        List<String> readFromAbbreviations = startLogByStreams.readFromStarter("src/main/resources/abbreviations.txt");

        Map<String, Date> startOfRacingByName =
                fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromStarter));
        Map<String, Date> finishOfRacingByName =
                fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromFinish));
        Map<String, Duration> timeOfRaceByKey = countingOfRaceTime.countRaceTime(startOfRacingByName, finishOfRacingByName);
        Map<String, String> fullNameByAbbreviation = mapFormList.getMapFromList(readFromAbbreviations);
        Map<String, Duration> timeOfRacingByFullNameOfDrivers =
                fullNameByAbbreviationObj.putFullNameOfDriversInsteadOfAbbreviations(timeOfRaceByKey, fullNameByAbbreviation);
        Map<String,String> timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers =
                convertedTimeForFinalResult.convertTimeFromMillisecondsToHours(timeOfRacingByFullNameOfDrivers);
        Map<String, String> sortedTimeOfRacingByFullName = timeSorting.sortedTimeFromSmallestToLargest(timeOfRacingInHoursMinutesSecondsByFullNameOfDrivers);

        String tableOutput = tableFormat.buildTheTableForOutputTheResult(sortedTimeOfRacingByFullName);

    return  tableOutput;
    }
    }

