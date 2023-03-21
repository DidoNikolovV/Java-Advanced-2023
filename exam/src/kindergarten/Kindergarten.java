package kindergarten;


import java.util.*;

public class Kindergarten {
    private String name;
    private int capacity;
    List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if(registry.size() < capacity) {
            this.registry.add(child);
            return true;
        }

        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if(child.getFirstName().equals(firstName)) {
                this.registry.remove(child);
                return true;
            }
        }

        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }



    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }

        return null;
    }

    public String registryReport() {
        Collections.sort(registry);
        StringBuilder builder = new StringBuilder();
        builder.append("Registered children in ").append(this.name).append(":").append(System.lineSeparator()).append("--").append(System.lineSeparator());
        for (int i = 0; i < registry.size(); i++) {{
            if(i + 1 == registry.size()) {
                builder.append(registry.get(i).toString());
            } else {
                builder.append(registry.get(i).toString()).append(System.lineSeparator()).append("--").append(System.lineSeparator());
            }
        }

        }

        return builder.toString().trim();
    }
}
