package SoftUniParty;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> reservations = new TreeSet<>();

        String guest = scanner.nextLine();


        while(!guest.equals("PARTY"))  {
            reservations.add(guest);

            guest = scanner.nextLine();
        }

        String input = scanner.nextLine();

        while(!input.equals("END")) {
            if(reservations.contains(input)) {
                reservations.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(reservations.size());
        for (String g : reservations) {
            System.out.println(g);
        }


    }
}
