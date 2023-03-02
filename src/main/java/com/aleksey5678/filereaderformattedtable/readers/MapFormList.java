package com.aleksey5678.filereaderformattedtable.readers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFormList {
    Map<String, String> timeByAbbreviation = new HashMap<>();

    public Map<String, String> getMapFromList(List<String> contentFromFile) {
        for (String listContent : contentFromFile) {
            timeByAbbreviation.put(listContent.substring(0, 3), listContent.substring(3));
        }
        return timeByAbbreviation;
    }
}
