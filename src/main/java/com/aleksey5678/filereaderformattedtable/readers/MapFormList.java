package com.aleksey5678.filereaderformattedtable.readers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFormList {
    Map<String, String>map=new HashMap<>();

    public  Map<String,String> getMapFromList(List<String>readFromStarter){
        for(String i :readFromStarter){
            map.put(i.substring(0, 3), i.substring(3));
        }
       return map;
    }

}
