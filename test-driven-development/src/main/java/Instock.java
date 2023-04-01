import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {


    List<Product> products;

    public Instock() {
        this.products = new LinkedList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product p : this.products) {
            if(p.getLabel().equals(product.getLabel())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void add(Product product) {
        if(products.contains(product)) {
            return;
        }
        products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        for (Product p : products){
            if(p.getLabel().equals(product)) {
               p.setQuantity(quantity);
               return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Product find(int index) {
        for (int i = 0; i < products.size(); i++) {
            if(i == index) {
                return products.get(i);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Product findByLabel(String label) {
        for (Product p : products) {
            if (p.getLabel().equals(label)) {
                return p;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }


}
