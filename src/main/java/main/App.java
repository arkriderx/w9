package main;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 310);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 N", 320);

        Driver ogier = new Driver("Sebastien Ogier", "France", gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", asphaltCar);
        Driver tanak = new Driver("Ott Tanak", "Estonia", gravelCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland");
        race1.recordResult(ogier,1);
        race1.recordResult(tanak,2);
        race1.recordResult(rovanpera,3);
        race1.recordResult(neuville,4);

        manager.addRace(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally");
        race2.recordResult(rovanpera,1);
        race2.recordResult(neuville,2);
        race2.recordResult(ogier,3);
        race2.recordResult(tanak,4);

        manager.addRace(race2);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");

        for (Driver d : manager.getDrivers()) {
            System.out.println(d.getName() + " (" + d.getCountry() + "): " + d.getTotalPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeader().getName() + " with " + manager.getLeader().getTotalPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");

        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.totalRacesHeld());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.averagePointsPerDriver());
        System.out.println("Most Successful Country: " + ChampionshipStatistics.mostSuccessfulCountry());
        System.out.println("Total Championship Points: " + manager.getTotalPoints());

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}