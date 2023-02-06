package CustomList;

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

    public T remove(int index) {
        return this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(values, index1, index2);
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream()
                .filter(value -> value.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.values.stream()
                .max((f, s) -> f.compareTo(s))
                .get();
    }

    public T getMin() {
        return this.values.stream()
                .min((f, s) -> f.compareTo(s))
                .get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : this.values) {
            sb.append(value).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
