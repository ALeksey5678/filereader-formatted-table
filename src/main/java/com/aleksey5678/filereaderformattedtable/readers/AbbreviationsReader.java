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
                    new FileReader("src/main/resources/abbreviations.txt"));

            Map<String, String> completeCharacteristicByAbbreviationOfDrivers = new HashMap<>();

            while (true) {
                String reader = readerFromFile.readLine();

                if (!(reader != null)) break;
                String fullInformationAboutDrivers = reader.substring(3);
                String abbreviationsOfDrivers = reader.substring(0, 3);
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
