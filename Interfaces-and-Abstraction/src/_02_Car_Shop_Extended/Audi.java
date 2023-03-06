package _02_Car_Shop_Extended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double minPricerPerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double minPricerPerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.minPricerPerDay = minPricerPerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return minPricerPerDay;
    }

    @Override
    public String toString() {
        return String.format(
                super.toString()
                +  "%n%s is %s color and have %d horse power",
                getModel(),
                getHorsePower(),
                TIRES
        );
    }
}
