package _01_Car_Shop;

public class Seat implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduces;

    public Seat(String model, String color, Integer horsePower, String countryProduces) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduces = countryProduces;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduces;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                model,
                countryProduces,
                tires
        );
    }
}
