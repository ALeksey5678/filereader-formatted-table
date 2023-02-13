package com.aleksey5678.filereaderformattedtable.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StartLog {
    public void readFromStartLog() {
        BufferedReader readerFromFile=null;
        try {
            readerFromFile = new BufferedReader(
                    new FileReader("src/main/resources/start.log"));
            Map<String, String> racingStartTimeByAbbreviationOfDrivers = new HashMap<>();

            while (true) {
                String reader = readerFromFile.readLine();

                if (reader == null) break;
                String timeOfRacing = reader.substring(3);
                String abbreviationOfDrivers = reader.substring(0, 3);
                racingStartTimeByAbbreviationOfDrivers.put(abbreviationOfDrivers, timeOfRacing);
            }

            for (Map.Entry entry : racingStartTimeByAbbreviationOfDrivers.entrySet()) {
                System.out.println(entry);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (readerFromFile != null) {
                try {
                    readerFromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}