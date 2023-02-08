package ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.index = 0;
    }


    public boolean move() {
        if(hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < this.elements.size() - 1;
    }

    public void print() {
        if(this.elements.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(index));
    }

    public void printAll() {
        StringBuilder result = new StringBuilder();
        for (String element : elements) {
            result.append(element).append(" ");
        }

        System.out.println(result.toString().join(" ", result.toString()));

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int internalIndex = 0;
            @Override
            public boolean hasNext() {
                return internalIndex < elements.size() - 1;
            }

            @Override
            public String next() {
                String element = elements.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }
}
