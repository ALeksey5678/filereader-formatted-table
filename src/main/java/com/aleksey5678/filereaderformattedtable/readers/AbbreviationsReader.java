package com.aleksey5678.filereaderformattedtable.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AbbreviationsReader {
    public void readFromAbbreviationsReader() {

        try {
            BufferedReader readerFromFile = new BufferedReader(
                    new FileReader("C:\\Users\\admin\\Desktop\\6 th lesson\\data\\abbreviations.txt"));
            String informationAboutDrivers;
            Map<String, String> completeCharacteristicByAbbreviationOfDrivers = new HashMap<>();

            while ((informationAboutDrivers = readerFromFile.readLine()) != null) {
                String fullInformationAboutDrivers = informationAboutDrivers.substring(3);
                String abbreviationsOfDrivers = informationAboutDrivers.substring(0, 3);
                completeCharacteristicByAbbreviationOfDrivers.put(abbreviationsOfDrivers, fullInformationAboutDrivers);
            }

            for (Map.Entry entry : completeCharacteristicByAbbreviationOfDrivers.entrySet()) {
                System.out.println(entry);
            }
            readerFromFile.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
