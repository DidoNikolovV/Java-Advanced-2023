package _03_Shopping_Spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if(this.money < product.getCost()) {
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }

        this.products.add(product);
        this.money -= product.getCost();

    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
