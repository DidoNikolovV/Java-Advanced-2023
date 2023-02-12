package sanctuary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {
        if(this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant e : this.data) {
            if(e.getName().equals(name)) {
                this.data.remove(e);
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant e : this.data) {
            if(e.getRetiredFrom().equals(retiredFrom)) {
                return e;
            }
        }

        return null;
    }

    public Elephant getOldestElephant() {
        return this.data.stream().sorted((f, s) -> s.getAge() - f.getAge()).collect(Collectors.toList()).get(0);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        for (Elephant e : this.data) {
            String str = String.format("%s came from: %s", e.getName(), e.getRetiredFrom());
            sb.append(str).append(System.lineSeparator());
        }
        return String.format("Saved elephants in the park: %n%s", sb.toString());
    }
}
