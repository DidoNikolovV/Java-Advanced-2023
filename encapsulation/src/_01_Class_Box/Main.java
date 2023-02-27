package _01_Class_Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurface());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }



    }
}
