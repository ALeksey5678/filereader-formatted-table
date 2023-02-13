package com.aleksey5678.filereaderformattedtable.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EndLog {
    public void readFromEndLog() {

        try {
            BufferedReader readerFromFile = new BufferedReader(
                    new FileReader("src/main/resources/end.log"));

            Map<String, String> raceEndTimeByAbbreviationOfDrivers = new HashMap<>();

            while (true) {
                String reader = readerFromFile.readLine();

                if (!(reader != null)) break;
                String raceEndTime = reader.substring(3);
                String abbreviationsOfDrivers = reader.substring(0, 3);
                raceEndTimeByAbbreviationOfDrivers.put(abbreviationsOfDrivers, raceEndTime);
            }

            for (Map.Entry entry : raceEndTimeByAbbreviationOfDrivers.entrySet()) {
                System.out.println(entry);
            }
            readerFromFile.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
