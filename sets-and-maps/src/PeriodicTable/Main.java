package PeriodicTable;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfChemical = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalTrack = new TreeSet<>();
        while(numberOfChemical-- > 0) {
            String[] chemicalCompounds = scanner.nextLine().split("\\s+");
            for (String chemicalCompound : chemicalCompounds) {
                chemicalTrack.add(chemicalCompound);
            }
        }

        for (String s : chemicalTrack) {
            System.out.print(s + " ");
        }
    }
}
