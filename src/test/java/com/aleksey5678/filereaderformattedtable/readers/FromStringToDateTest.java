package com.aleksey5678.filereaderformattedtable.readers;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FromStringToDateTest {
    private final FromStringToDate fromStringToDate = new FromStringToDate();
    private final DateFormat expectedFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    @Test
    void shouldFormatFromStringToDate() {
        Map<String, String> timeByName = new HashMap<>();
        timeByName.put("event1", "2023-03-23_13:30:00.000");
        timeByName.put("event2", "2023-04-15_18:45:30.500");

        Map<String, Date> dateByName = fromStringToDate.formatFromStringToDate(timeByName);

        assertEquals("2023-03-23_13:30:00.000", expectedFormat.format(dateByName.get("event1")));
        assertEquals("2023-04-15_18:45:30.500", expectedFormat.format(dateByName.get("event2")));
    }

    @Test
    void shouldThrowRunTimeExceptionIfWrongDateFormat() {
        Throwable actualException = assertThrows(RuntimeException.class, () -> fromStringToDate.dateFromString("invalid date string"));

        String expectedMessage = "Can not parse date from string invalid date string";

        assertEquals(expectedMessage, actualException.getMessage());
    }
}

