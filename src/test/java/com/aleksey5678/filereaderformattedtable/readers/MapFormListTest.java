package com.aleksey5678.filereaderformattedtable.readers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapFormListTest {
    private final MapFormList mapFormList = new MapFormList();

    @Test
    void shouldGetMapFromList() {

        List<String> inputList = Arrays.asList("ASD12345", "AZX21345", "MUQ0987");
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("ASD", "12345");
        expectedMap.put("AZX", "21345");
        expectedMap.put("MUQ", "0987");

        Map<String, String> actualMap = mapFormList.getMapFromList(inputList);

        assertEquals(expectedMap, actualMap);
    }
}