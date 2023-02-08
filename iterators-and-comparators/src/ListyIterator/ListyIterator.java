package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator {
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
}
