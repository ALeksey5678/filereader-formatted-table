package com.aleksey5678.filereaderformattedtable.starter;

import com.aleksey5678.filereaderformattedtable.readers.AbbreviationsReader;
import com.aleksey5678.filereaderformattedtable.readers.FromStringToDate;
import com.aleksey5678.filereaderformattedtable.readers.MapFormList;
import com.aleksey5678.filereaderformattedtable.readers.StartLogByStreams;

import java.util.List;


public class Starter {
    public static void main(String[] args) {
        StartLogByStreams startLogByStreams=new StartLogByStreams();
        EndLog endLog = new EndLog();
        AbbreviationsReader abbreviationsReader = new AbbreviationsReader();
        StartLog startLog=new StartLog();
        List<String> readFromStarter = startLogByStreams.readFromStarter("src/main/resources/start.log");
        List<String> readFromFinish = startLogByStreams.readFromStarter("src/main/resources/end.log");
        MapFormList mapFormList=new MapFormList();
        FromStringToDate fromStringToDate=new FromStringToDate();
        System.out.println(fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromStarter)));
        System.out.println(fromStringToDate.formatFromStringToDate(mapFormList.getMapFromList(readFromFinish)));
//общий клас для чтения файлов, в чем хранить дату и время,Лист?
    }
}
