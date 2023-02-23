package com.aleksey5678.filereaderformattedtable.readers;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FullNameByAbbreviationTest {
    private final FullNameByAbbreviation fullNameByAbbreviation = new FullNameByAbbreviation();

    @Test
    void putFullNameOfDriversInsteadOfAbbreviations() {
        Map<String, Duration> timeOfRacingByAbbreviations = new HashMap<>();
        timeOfRacingByAbbreviations.put("AB", Duration.ofMinutes(60));
        timeOfRacingByAbbreviations.put("BRB", Duration.ofMillis(50));
        timeOfRacingByAbbreviations.put("BAB", Duration.ofMinutes(54).plusSeconds(15));

        Map<String, String> fullNAmeByAbbreviation = new HashMap<>();
        fullNAmeByAbbreviation.put("AB", "Ancient Beast");
        fullNAmeByAbbreviation.put("BRB", "BE Right Back");
        fullNAmeByAbbreviation.put("BAB", "Being Absolutely Boring");

        Map<String, Duration> expectedResult = new HashMap<>();
        expectedResult.put("Ancient Beast", Duration.ofMinutes(60));
        expectedResult.put("BE Right Back", Duration.ofMillis(50));
        expectedResult.put("Being Absolutely Boring", Duration.ofMinutes(54).plusSeconds(15));

        Map<String, Duration> actualTimeByFullNameOfDrivers =
                fullNameByAbbreviation.putFullNameOfDriversInsteadOfAbbreviations(timeOfRacingByAbbreviations, fullNAmeByAbbreviation);

        assertEquals(expectedResult, actualTimeByFullNameOfDrivers);


    }
}