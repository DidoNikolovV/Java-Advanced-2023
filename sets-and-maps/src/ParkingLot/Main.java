package ParkingLot;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while(!input.equals("END")) {
            String[] inputParts = input.split(", ");
            String direction = inputParts[0];
            String carNumber = inputParts[1];

            if(direction.equals("IN")) {
                parking.add(carNumber);
            } else {
                parking.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if(parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : parking) {
                System.out.println(carNumber);
            }
        }
    }
}
