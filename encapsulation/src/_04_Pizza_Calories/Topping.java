package _04_Pizza_Calories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + weight + " on top of your pizza.");
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double caloriesPerGram = 0.0;
        switch (toppingType) {
            case "Meat":
                caloriesPerGram = 1.2;
                break;
            case "Veggies":
                caloriesPerGram = 0.8;
                break;
            case "Cheese":
                caloriesPerGram = 1.1;
                break;
            case "Sauce":
                caloriesPerGram = 0.9;
                break;
            default:
                throw new IllegalArgumentException("Invalid topping type");
        }

        return 2 * weight * caloriesPerGram;
    }
}
