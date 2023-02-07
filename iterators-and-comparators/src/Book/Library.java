package Book;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {

    private class LibIterator implements Iterator<Book> {
        private int counter = 0;

        public boolean hasNext() {
            return counter < books.size();
        }

        public Book next() {
            return books.get(counter++);
        }
    }
    private List<Book> books;

    public Library(Book... books) {
        this.setBooks(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book... books) {
        this.books = Arrays.asList(books);
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
