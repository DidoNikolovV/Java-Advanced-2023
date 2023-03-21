package _04_Pizza_Calories;

import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    private void setToppings(int numberOfToppings) {
        if(numberOfToppings < 1 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double overallCalories = 0.0;
        for (Topping topping : toppings) {
            overallCalories += topping.calculateCalories();
        }

        return overallCalories;
    }
}
