package easterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private String material;
    private int capacity;
    List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if(this.data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if(egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }

        return false;
    }

    public Egg getStrongestEgg() {
        if(getCount() == 0) {
            return null;
        }

        return this.data.stream().sorted((f, s) -> s.getStrength() - f.getStrength()).collect(Collectors.toList()).get(0);
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.material).append(" basket contains: ").append(System.lineSeparator());
        for (Egg egg : this.data) {
            builder.append(egg.toString()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
