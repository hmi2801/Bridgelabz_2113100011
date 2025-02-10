package Assignment13;

abstract class Vehicle2 {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle2(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver Name: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

interface LocationTracking {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car2 extends Vehicle2 implements LocationTracking {
    private String currentLocation;

    public Car2(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Bike2 extends Vehicle2 implements LocationTracking {
    private String currentLocation;

    public Bike2(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Auto2 extends Vehicle2 implements LocationTracking {
    private String currentLocation;

    public Auto2(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 10; // Additional charge for auto
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle2 car2 = new Car2("V001", "John", 15.0);
        Vehicle2 bike2 = new Bike2("V002", "Sam", 8.0);
        Vehicle2 auto2 = new Auto2("V003", "Mike", 12.0);

        System.out.println(car2.getVehicleDetails());
        System.out.println("Fare for 10 km: " + car2.calculateFare(10));

        System.out.println(bike2.getVehicleDetails());
        System.out.println("Fare for 10 km: " + bike2.calculateFare(10));

        System.out.println(auto2.getVehicleDetails());
        System.out.println("Fare for 10 km: " + auto2.calculateFare(10));

        LocationTracking gpsCar2 = (LocationTracking) car2;
        gpsCar2.updateLocation("Point A");
        System.out.println("Car2 current location: " + gpsCar2.getCurrentLocation());

        LocationTracking gpsBike2 = (LocationTracking) bike2;
        gpsBike2.updateLocation("Point B");
        System.out.println("Bike2 current location: " + gpsBike2.getCurrentLocation());

        LocationTracking gpsAuto2 = (LocationTracking) auto2;
        gpsAuto2.updateLocation("Point C");
        System.out.println("Auto2 current location: " + gpsAuto2.getCurrentLocation());
    }
}
