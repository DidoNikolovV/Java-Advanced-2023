package AverageStudentsGrades;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] inputParts = scanner.nextLine().split("\\s+");
            String student = inputParts[0];
            double grade = Double.parseDouble(inputParts[1]);
            if(!studentsGrades.containsKey(student)) {
                List<Double> grades = new ArrayList<>();
                studentsGrades.put(student, grades);
            }
            studentsGrades.get(student).add(grade);
        }

        for(String stud : studentsGrades.keySet()) {
            System.out.printf("%s -> ", stud);
            double average = 0.0;
            for (Double grade : studentsGrades.get(stud)) {
                average += grade;
                System.out.printf("%.2f ", grade);
            }
            average /= studentsGrades.get(stud).size();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
