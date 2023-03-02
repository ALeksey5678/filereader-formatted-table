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
        for (Map.Entry<String, String> nameAndTime : timeByName.entrySet()) {
            dateByName.put(nameAndTime.getKey(), dateFromString(nameAndTime.getValue()));
        }
        return dateByName;
    }

    public Date dateFromString(String dateBeforeParsing) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

        try {
            return format.parse(dateBeforeParsing);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Can not parse date from string " + dateBeforeParsing);
    }
}

