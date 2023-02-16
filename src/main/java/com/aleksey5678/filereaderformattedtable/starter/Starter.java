package com.aleksey5678.filereaderformattedtable.starter;

import com.aleksey5678.filereaderformattedtable.readers.FromStringToDate;
import com.aleksey5678.filereaderformattedtable.readers.MapFormList;
import com.aleksey5678.filereaderformattedtable.readers.StartLogByStreams;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Starter {
    public static void main(String[] args) {
        Starter starter=new Starter();
        StartLogByStreams startLogByStreams = new StartLogByStreams();
        MapFormList mapFormList = new MapFormList();
        FromStringToDate fromStringToDate = new FromStringToDate();

        List<String> readFromStarter = startLogByStreams.readFromStarter("src/main/resources/start.log");
        List<String> readFromFinish = startLogByStreams.readFromStarter("src/main/resources/end.log");

        Map<String, Date> DateOfStartByName = fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromStarter));
        Map<String, Date> DateOfFinishByName = fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromFinish));

      /*  System.out.println(DateOfStartByName);
        System.out.println(DateOfFinishByName);*/
        System.out.println(starter.compareMaps(DateOfStartByName,DateOfFinishByName));

//общий клас для чтения файлов, в чем хранить дату и время,Лист?

    }

    public Map<String,Long> compareMaps(Map<String, Date> start, Map<String, Date> finish) {
        Map<String, Long> timeInSecondsByAbbreviation = new HashMap<>();
        for (String key : start.keySet()) {
            Date date1 = start.get(key);
            Date date2 = finish.get(key);
            long differenceBetweenFinishAndStart = date2.getTime() - date1.getTime();
            timeInSecondsByAbbreviation.put(key, differenceBetweenFinishAndStart);

        }
        return timeInSecondsByAbbreviation;
    }
}
