package com.aleksey5678.filereaderformattedtable.starter;

import com.aleksey5678.filereaderformattedtable.readers.AbbreviationsReader;
import com.aleksey5678.filereaderformattedtable.readers.EndLog;
import com.aleksey5678.filereaderformattedtable.readers.StartLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Starter {
    public static void main(String[] args) {
        EndLog endLog = new EndLog();
        AbbreviationsReader abbreviationsReader = new AbbreviationsReader();
        StartLog startLog=new StartLog();
        abbreviationsReader.readFromAbbreviationsReader();
        endLog.readFromEndLog();
        startLog.readFromStartLog();


    }
}
