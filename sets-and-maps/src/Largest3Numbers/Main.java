package Largest3Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((f, s) -> s.compareTo(f))
                .collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3) {
                break;
            }
            System.out.print(sorted.get(i) + " ");
        }
    }
}
