package _02_Car_Shop_Extended;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(
                super.toString()
                        + "%n%s is %s color and have %d horse power",
                getModel(),
                getColor(),
                getHorsePower(),
                TIRES
        );
    }
}
