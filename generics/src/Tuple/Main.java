package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personData = scanner.nextLine().split("\\s+");
        String fullName = personData[0] + " " + personData[1];
        String address = personData[2];

        Tuple<String, String> firstTuple = new Tuple<String, String>(fullName, address);

        personData = scanner.nextLine().split("\\s+");
        String firstName = personData[0];
        int litersOfBeer = Integer.parseInt(personData[1]);
        Tuple<String, Integer> secondTuple = new Tuple<String, Integer>(firstName, litersOfBeer);


        String[] data = scanner.nextLine().split("\\s+");
        Integer num = Integer.parseInt(data[0]);
        Double dble = Double.parseDouble(data[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<Integer, Double>(num, dble);

        System.out.println(firstTuple.toString());
        System.out.println(secondTuple.toString());
        System.out.println(thirdTuple.toString());

    }
}
