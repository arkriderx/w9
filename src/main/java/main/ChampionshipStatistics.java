package main;

import java.util.HashMap;
import java.util.Map;

public class ChampionshipStatistics {

    public static double averagePointsPerDriver() {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        int totalPoints = manager.getTotalPoints();
        int totalDrivers = Driver.getTotalDrivers();

        return (double) totalPoints / totalDrivers;
    }

    public static String mostSuccessfulCountry() {

        ChampionshipManager manager = ChampionshipManager.getInstance();
        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver d : manager.getDrivers()) {
            countryPoints.put(
                    d.getCountry(),
                    countryPoints.getOrDefault(d.getCountry(), 0) + d.getTotalPoints()
            );
        }

        return countryPoints.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static int totalRacesHeld() {
        return ChampionshipManager.getInstance().getRaces().size();
    }
}