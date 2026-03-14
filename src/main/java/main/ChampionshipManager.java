package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers = new ArrayList<>();
    private List<RaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRace(RaceResult race) {
        races.add(race);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RaceResult> getRaces() {
        return races;
    }

    public Driver getLeader() {
        return drivers.stream()
                .max(Comparator.comparingInt(Driver::getTotalPoints))
                .orElse(null);
    }

    public int getTotalPoints() {
        return drivers.stream()
                .mapToInt(Driver::getTotalPoints)
                .sum();
    }
}
