package _03_Shopping_Spree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleInput = scanner.nextLine().split(";");

        List<Person> people = new LinkedList<>();


        for (String p : peopleInput) {
            String[] personData = p.split("=");
            String personName = personData[0];
            double money = Double.parseDouble(personData[1]);

            Person person = new Person(personName, money);
            people.add(person);
        }

        String[] productsInput = scanner.nextLine().split(";");

        List<Product> products = new ArrayList<>();

        for(String p : productsInput) {
            String[] productData = p.split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);

            Product product = new Product(productName, productCost);
            products.add(product);
        }

        String command = scanner.nextLine();
        while(!command.equals("END")) {
            String[] cmdParts = command.split("\\s+");
            String personName = cmdParts[0];
            String productName = cmdParts[1];

            Person foundPerson = findPerson(personName, people);
            Product foundProduct = findProduct(productName, products);

            if(foundPerson != null && foundProduct != null) {
                try {
                    foundPerson.buyProduct(foundProduct);
                    System.out.println(foundPerson.getName() + " bought " + foundProduct.getName());
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            command = scanner.nextLine();
        }

        for (Person person : people) {
            List<String> productsNames = new ArrayList<>();
            for (Product product : person.getProducts()) {
                productsNames.add(product.getName());
            }

            if(productsNames.isEmpty()) {
                System.out.println(person.getName() + " - " + "Nothing bought");
            } else {
                System.out.println(person.getName() + " - " + String.join(", ", productsNames));
            }
        }

    }

    private static Product findProduct(String productName, List<Product> products) {
        int productIndex = -1;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equals(productName)) {
                productIndex = i;
                break;
            }
        }

        if(productIndex == -1) {
            return null;
        }

        return products.get(productIndex);
    }
    private static Person findPerson(String personName, List<Person> people) {
        int personIndex = -1;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getName().equals(personName)) {
                personIndex = i;
                break;
            }
        }

        if(personIndex == -1) {
            return null;
        }

        return people.get(personIndex);
    }
}
