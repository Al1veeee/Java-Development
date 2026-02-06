package ru.week4.task4;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.addVehicle(new Car("Toyota", "Camry", 2022, 4));
        garage.addVehicle(new ElectricCar("Tesla", "Model 3", 2023, 4));
        garage.addVehicle(new Motorcycle("Harley", "Davidson", 2021, false));

        garage.startAllVehicles();
        garage.chargeAllElectric();
        Vehicle fastest = garage.findFastestVehicle();
        System.out.println("Самый быстрый: " + fastest.getMaxSpeed());
    }
}
