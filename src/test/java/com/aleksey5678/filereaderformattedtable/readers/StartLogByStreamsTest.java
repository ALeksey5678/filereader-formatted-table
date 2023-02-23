package com.aleksey5678.filereaderformattedtable.readers;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StartLogByStreamsTest {
    private final StartLogByStreams startLogByStreams=new StartLogByStreams();

    @Test
        public void testReadFromStarter() {

            String pathToFile = "src/test/resources/my file.txt";
            List<String> expectedList = Arrays.asList("hello", "world", "java");

            List<String> actualList = startLogByStreams.readFromStarter(pathToFile);
            assertEquals(expectedList, actualList);
        }

        @Test
        public void testReadFromStarterEmptyFile() {

            String pathToFile = "src/test/resources/emptyfile.txt";
            List<String> expectedList = Collections.emptyList();

            List<String> actualList = startLogByStreams.readFromStarter(pathToFile);
            assertEquals(expectedList, actualList);
        }

        @Test
        public void testReadFromStarterNonExistentFile() {

            String pathToFile = "src/test/resources/wrong path.txt";

            Exception exception = assertThrows(IOException.class, () -> {
                startLogByStreams.readFromStarter(pathToFile);
            });

            String expectedMessage = "No such file or directory";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
