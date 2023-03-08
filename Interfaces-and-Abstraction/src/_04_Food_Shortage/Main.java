package _04_Food_Shortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> consumers = new HashMap<>();
        Buyer consumer = null;
        for (int i = 0; i < numPeople; i++) {
            String input = scanner.nextLine();
            String[] inputParts = input.split("\\s+");

            switch(inputParts.length) {
                case 3:
                    consumer = new Rebel(inputParts[0], Integer.parseInt(inputParts[1]), inputParts[2]);
                    break;
                case 4:
                    consumer = new Citizen(inputParts[0], Integer.parseInt(inputParts[1]), inputParts[2], inputParts[3]);
                    break;
                default:
                    throw new IllegalStateException("Invalid input " + input);
            }

            consumers.put(inputParts[0], consumer);
        }

        String command = scanner.nextLine();

        while(!command.equals("End")) {
            String name = command;
            if(consumers.get(name) != null) {
                consumers.get(name).buyFood();
            }


            command = scanner.nextLine();
        }

        int totalFoodBought = 0;
        for (var c : consumers.entrySet()) {
            totalFoodBought += c.getValue().getFood();
        }

        System.out.println(totalFoodBought);
    }
}
