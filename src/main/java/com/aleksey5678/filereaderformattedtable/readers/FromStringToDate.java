package com.aleksey5678.filereaderformattedtable.readers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FromStringToDate {
    public Map<String, Date> formatFromStringToDate(Map<String, String> timeByName) {
        Map<String, Date> dateByName = new HashMap<>();
        for (Map.Entry<String, String> stringStringEntry : timeByName.entrySet()) {
            dateByName.put(stringStringEntry.getKey(), dateFromString(stringStringEntry.getValue()));
        }
        return dateByName;
    }

    public Date dateFromString(String value) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

        try {
            Date date = format.parse(value);
            System.out.println(date);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Can not parse date from string " + value);
    }
}

