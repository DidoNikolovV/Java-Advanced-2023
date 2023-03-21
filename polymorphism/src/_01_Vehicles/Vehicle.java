package _01_Vehicles;

public abstract class Vehicle {
    double fuelQuantity;
    double fuelConsumptionsPerKmLiters;


    public Vehicle(double fuelQuantity, double fuelConsumptionsPerKmLiters) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionsPerKmLiters = fuelConsumptionsPerKmLiters;
    }



    abstract double increasedFuel();

    abstract void refuel(double fuel);
    abstract void drive(int kilometers);

}
