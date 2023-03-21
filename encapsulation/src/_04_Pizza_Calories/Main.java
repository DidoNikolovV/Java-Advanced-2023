package _04_Pizza_Calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        try {
            Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));

            String[] doughData = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));

            String[] toppingData = scanner.nextLine().split("\\s+");
            Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));


        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
