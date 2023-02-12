package Exam_18_Augst;

import com.sun.jdi.ArrayReference;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licences = new ArrayDeque<>();
        ArrayDeque<Integer> cars = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(licences::offer);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(cars::push);

        int days = 0;
        int totalRegisteredCars = 0;


        int carsThatCanBeRegistered = 0;
        while(licences.size() != 0 && cars.size() != 0) {
            int license = licences.poll();
            int car = cars.pop();

            int remainingCars = 0;
            int remainingLicense = 0;
            carsThatCanBeRegistered = license / 2;
            if(carsThatCanBeRegistered >= car) {
                remainingLicense = license - car * 2;
                totalRegisteredCars += car;
            } else {
                remainingCars = car - carsThatCanBeRegistered;
                totalRegisteredCars += car - remainingCars;
            }


            if(remainingCars != 0) {
                cars.push(remainingCars);
            }
            if(remainingLicense != 0) {
                licences.offer(remainingLicense);
            }

            days++;

        }

        System.out.printf("%d cars were registered for %d days!%n", totalRegisteredCars, days);

        if(licences.size() != 0) {
            int platesRemaining = licences.stream().reduce(Integer::sum).get();
            System.out.printf("%d license plates remain!%n", platesRemaining);
        }

        if(cars.size() != 0) {
            System.out.printf("%d cars remain without license plates!%n", cars.size());

        }

        if(cars.size() == 0 && licences.size() == 0) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
