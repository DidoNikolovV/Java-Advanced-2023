package GenericSwapMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable> {
    List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }


    public void swap(int i, int j) {
        Collections.swap(values, i, j);
    }

    public int getGreaterElementsCount(T value) {
        return (int) this.values.stream()
                .filter(e -> e.compareTo(value) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }

        return sb.toString();
    }
}
