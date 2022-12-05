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
                    new FileReader("C:\\Users\\admin\\Desktop\\6 th lesson\\data\\end.log"));
            String informationAboutDriversAndRaceEndTime;
            Map<String, String> raceEndTimeByAbbreviationOfDrivers = new HashMap<>();

            while ((informationAboutDriversAndRaceEndTime = readerFromFile.readLine()) != null) {
                String raceEndTime = informationAboutDriversAndRaceEndTime.substring(3);
                String abbreviationsOfDrivers = informationAboutDriversAndRaceEndTime.substring(0, 3);
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
