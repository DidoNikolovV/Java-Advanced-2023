package _01_Vehicles;

public class Car extends Vehicle{


    public Car(double fuelQuantity, double fuelConsumptionsPerKmLiters) {
        super(fuelQuantity, fuelConsumptionsPerKmLiters);
    }

    @Override
    double increasedFuel() {
        return fuelConsumptionsPerKmLiters * 0.9;
    }

    @Override
    void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    void drive(int kilometers) {
        double fuelNeeded = increasedFuel() * kilometers;
        if(fuelNeeded <= fuelQuantity) {
            fuelQuantity -= fuelConsumptionsPerKmLiters * kilometers;
        }
    }
}
