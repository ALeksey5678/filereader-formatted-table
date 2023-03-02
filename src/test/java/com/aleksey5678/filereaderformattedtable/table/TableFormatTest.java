package com.aleksey5678.filereaderformattedtable.table;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TableFormatTest {
    private final TableFormat tableFormat = new TableFormat();

    @Test
    void buildTheTableForOutputTheResult() {
        Map<String, String> input = new HashMap<>();
        input.put("ASD_Name1_Company1", "1:11.111");
        input.put("SWX_Name2_Company2", "2:22.222");
        input.put("WSX_Name3_Company3", "3:33.333");

        String s = tableFormat.buildTheTableForOutputTheResult(input);

        String expectedResult = "1   Name1   Company1   1:11.111\n" +
                "2   Name2   Company2   2:22.222\n" +
                "3   Name3   Company3   3:33.333";

        assertEquals(expectedResult, s);
    }
}