package ProductShop;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> productShop = new TreeMap<>();

        String input = scanner.nextLine();

        while(!input.equals("Revision")) {
            String[] inputParts = input.split(", ");
            String shop = inputParts[0];
            String product = inputParts[1];
            Double price = Double.parseDouble(inputParts[2]);
            Map<String, Double> productInfo = new LinkedHashMap<>();
            if(!productShop.containsKey(shop)) {
                productShop.put(shop, productInfo);
            }

            productShop.get(shop).put(product, price);
            input = scanner.nextLine();
        }

        for(var shop: productShop.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (var shopInfo : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", shopInfo.getKey(), shopInfo.getValue());
            }
        }


    }
}
