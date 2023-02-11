package Exam_14_October;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet p : this.data) {
            if(p.getName().equals(name)) {
                this.data.remove(p);
                return true;
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                return p;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return this.data.stream().sorted((f, s) -> s.getAge() - f.getAge()).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Pet p : this.data) {
            builder.append(p.getName()).append(" ").append(p.getOwner()).append(System.lineSeparator());
        }
        return String.format("The clinic has the following patients: %n%s",
                builder.toString()
        );
    }
}
