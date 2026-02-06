package ru.week4.task4;

import java.util.ArrayList;
import java.util.Comparator;

public class Garage {
    private final ArrayList<Vehicle> garage = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        System.out.println("Машина въехала в гараж");
        garage.add(v);
    }

    public void removeVehicle(String model) {
        for (Vehicle v : garage) {
            if (v.model == model) {
                garage.remove(v);
            }
        }
        System.out.println("Машина выехала из гаража");
    }
    public void startAllVehicles() {
        System.out.println("Все машины заведены");
    }
    public void stopAllVehicles() {
        System.out.println("Все машины остановлены");
    }

    public Vehicle findFastestVehicle() {
        if (garage.isEmpty()) return null;

        Vehicle fastest = garage.get(0);

        for (Vehicle v : garage) {
            if (v.getMaxSpeed() > fastest.getMaxSpeed()) fastest = v;
        }
        return fastest;
    }

    public void chargeAllElectric() {
        for (Vehicle v : garage) {
            if (v instanceof Chargeable c) {
                c.charge();
            }
        }
        System.out.println("Все машины заряжены");
    }
}
