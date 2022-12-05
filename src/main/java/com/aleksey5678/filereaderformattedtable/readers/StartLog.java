package com.aleksey5678.filereaderformattedtable.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StartLog {
    public void readFromStartLog() {
        try {
            BufferedReader readerFromFile = new BufferedReader(
                    new FileReader("C:\\Users\\admin\\Desktop\\6 th lesson\\data\\start.log"));
            String informationAboutDriversAndTimeWhenRacingBegan;
            Map<String, String> timeOWhenRacingBeganByAbbreviationOfDrivers = new HashMap<>();

            while ((informationAboutDriversAndTimeWhenRacingBegan = readerFromFile.readLine()) != null) {
                String timeOfRacing = informationAboutDriversAndTimeWhenRacingBegan.substring(3);
                String abbreviationsOfDrivers = informationAboutDriversAndTimeWhenRacingBegan.substring(0, 3);
                timeOWhenRacingBeganByAbbreviationOfDrivers.put(abbreviationsOfDrivers, timeOfRacing);
            }

            for (Map.Entry entry : timeOWhenRacingBeganByAbbreviationOfDrivers.entrySet()) {
                System.out.println(entry);
            }
            readerFromFile.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
