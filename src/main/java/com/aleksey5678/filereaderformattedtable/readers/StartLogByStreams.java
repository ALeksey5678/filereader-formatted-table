package com.aleksey5678.filereaderformattedtable.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartLogByStreams {
    public List<String> readFromStarter(String pathToFile) {
        List<String> smth = null;

        try (Stream<String>lines= Files.lines(Paths.get(pathToFile))){
            smth=lines.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return smth;
    }
        }

