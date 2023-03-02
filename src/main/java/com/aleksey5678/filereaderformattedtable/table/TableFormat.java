package com.aleksey5678.filereaderformattedtable.table;

import java.util.Map;

public class TableFormat {
    private static final int ADDITIONAL_EMPTY_SPACE = 1;

    public String buildTheTableForOutputTheResult(Map<String, String> convertedTimeOfDrivingByFUllName) {

        int maxNameLength = 0;
        int maxTeamLength = 0;
        for (String racer : convertedTimeOfDrivingByFUllName.keySet()) {
            String[] parts = racer.split("_");
            String name = parts[1];
            String team = parts[2];
            maxNameLength = Math.max(maxNameLength, name.length());
            maxTeamLength = Math.max(maxTeamLength, team.length());
        }

        int placeWidth = Integer.max(4, String.valueOf(convertedTimeOfDrivingByFUllName.size()).length());
        int nameWidth = 0;
        int teamWidth = 0;
        int timeWidth = 0;

        for (Map.Entry<String, String> nameAndTime : convertedTimeOfDrivingByFUllName.entrySet()) {
            String[] parts = nameAndTime.getKey().split("_");
            String name = parts[1];
            String team = parts[2];
            String time = nameAndTime.getValue();

            nameWidth = Integer.max(nameWidth, name.length()) + ADDITIONAL_EMPTY_SPACE;
            teamWidth = Integer.max(teamWidth, team.length()) + ADDITIONAL_EMPTY_SPACE;
            timeWidth = Integer.max(timeWidth, time.length());
        }

        StringBuilder tableRows = new StringBuilder();

        int placeOfRacers = 1;

        for (Map.Entry<String, String> nameAndTime : convertedTimeOfDrivingByFUllName.entrySet()) {
            String[] parts = nameAndTime.getKey().split("_");
            String name = parts[1];
            String team = parts[2];
            String time = nameAndTime.getValue();
            String space = " ";
            tableRows.append(placeOfRacers).append(space.repeat(amountOfSpaces(placeWidth, String.valueOf(placeOfRacers).length())));
            tableRows.append(name).append(space.repeat(amountOfSpaces(nameWidth, name.length())));
            tableRows.append(team).append(space.repeat(amountOfSpaces(teamWidth, team.length())));
            tableRows.append(time).append(space.repeat(amountOfSpaces(timeWidth, time.length())));
            tableRows.append("\n");

            if (placeOfRacers == 15) {
                tableRows.append("_".repeat(Math.max(0, placeWidth + nameWidth + teamWidth + timeWidth)));
                tableRows.append("\n");
            }
            placeOfRacers++;
        }
        return tableRows.toString().trim();
    }

    public int amountOfSpaces(int width, int expressionWidth) {
        return width - expressionWidth;
    }
}



