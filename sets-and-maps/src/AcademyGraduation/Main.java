package AcademyGraduation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentInfo = new TreeMap<>();
        double avrg = 0;
        for(int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sumOfScores = 0;
            for(double score : scores) {
                sumOfScores += score;
            }

            avrg = sumOfScores / scores.length;
            studentInfo.put(name, avrg);
        }

        for(var entry: studentInfo.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}