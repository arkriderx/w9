package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private Map<Driver, Integer> results = new LinkedHashMap<>();

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public void recordResult(Driver driver, int position) {

        int points = switch (position) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            default -> 0;
        };

        driver.addPoints(points);
        results.put(driver, points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    @Override
    public String getRaceName() {
        return raceName;
    }
}