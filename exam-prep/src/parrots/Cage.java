package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if(this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if(parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }

        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if(parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }

        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = this.data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
        for (Parrot parrot : parrots) {
            parrot.setAvailable(false);
        }
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot parrot : this.data) {
            builder.append(parrot.toString()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

}
