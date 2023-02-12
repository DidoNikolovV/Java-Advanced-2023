package StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    ArrayDeque<Integer> elements;

    public Stack() {
        this.elements = new ArrayDeque<>();
    }

    public void push(Integer element) {
        elements.push(element);
    }

    public Integer pop() {
        if(elements.size() == 0) {
           throw new IllegalStateException("No elements");
        }
        return elements.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return elements.size() > 0;
            }

            @Override
            public Integer next() {
                return elements.pop();
            }
        };
    }
}
