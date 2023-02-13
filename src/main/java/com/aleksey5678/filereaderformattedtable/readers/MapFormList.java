package com.aleksey5678.filereaderformattedtable.readers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFormList {
    Map<String, String>map=new HashMap<>();

    public  void getMapFromList(List<String>readFromStarter){
        for(String i :readFromStarter){
            map.put(i.substring(0, 3), i.substring(3));
        }
        System.out.println(map);
    }

}
