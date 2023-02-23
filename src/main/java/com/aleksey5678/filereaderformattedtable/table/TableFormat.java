package com.aleksey5678.filereaderformattedtable.table;

import java.util.Map;

public class TableFormat {
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

        for (String key : convertedTimeOfDrivingByFUllName.keySet()) {
            String[] parts = key.split("_");
            String name = parts[1];
            String team = parts[2];
            String time = convertedTimeOfDrivingByFUllName.get(key);

            nameWidth = Integer.max(nameWidth, name.length()+2);
            teamWidth = Integer.max(teamWidth, team.length()+2);
            timeWidth = Integer.max(timeWidth, time.length());
        }

        StringBuilder sb = new StringBuilder();

        int placeOfRacers = 1;
        for (String key : convertedTimeOfDrivingByFUllName.keySet()) {
            String[] parts = key.split("_");
            String name = parts[1];
            String team = parts[2];
            String time = convertedTimeOfDrivingByFUllName.get(key);

            sb.append(String.format("%-" + placeWidth + "d", placeOfRacers));
            sb.append(String.format("%-" + nameWidth + "s", name));
            sb.append(String.format("%-" + teamWidth + "s", team));
            sb.append(String.format("%-" + timeWidth + "s", time));
            sb.append("\n");

            if (placeOfRacers == 15) {
                for (int generalWidth = 0; generalWidth < placeWidth + nameWidth + teamWidth + timeWidth; generalWidth++) {
                    sb.append("_");
                }
                sb.append("\n");
            }

            placeOfRacers++;
        }
            return sb.toString().trim();
        }
    }



