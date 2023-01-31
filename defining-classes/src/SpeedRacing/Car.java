package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public void drive(int amountOfKm) {
        double fuelNeeded = fuelCostPerKm * amountOfKm;
        if(fuelAmount >= fuelNeeded) {
            this.fuelAmount -= fuelNeeded;
            this.distanceTraveled += amountOfKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                this.model,
                this.fuelAmount,
                this.distanceTraveled
        );
    }
}
