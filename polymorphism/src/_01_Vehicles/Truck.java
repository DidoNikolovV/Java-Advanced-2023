package _01_Vehicles;

public class Truck extends Vehicle{
    public Truck(double fuelQuantity, double fuelConsumptionsPerKmLiters) {
        super(fuelQuantity, fuelConsumptionsPerKmLiters);
    }

    @Override
    double increasedFuel() {
        return fuelConsumptionsPerKmLiters * 1.6;
    }

    @Override
    void refuel(double fuel) {
        fuelQuantity += fuel * 0.95;
    }

    @Override
    void drive(int kilometers) {
        double fuelNeeded = increasedFuel() * kilometers;
        if(fuelNeeded <= fuelQuantity) {
            fuelQuantity -= fuelConsumptionsPerKmLiters * kilometers;
        }
    }
}
