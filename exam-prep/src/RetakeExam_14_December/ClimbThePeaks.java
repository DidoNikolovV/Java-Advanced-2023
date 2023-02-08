package RetakeExam_14_December;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> dailyFood = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(dailyFood::push);

        ArrayDeque<Integer> dailyStamine = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(dailyStamine::offer);

        List<String> peaks = new LinkedList<>();
        peaks.add("Vihren - 80");
        peaks.add("Kutelo - 90");
        peaks.add("Banski Suhodol - 100");
        peaks.add("Polezhan - 60");
        peaks.add("Kamenitza - 70");



        int counter = 0;
        boolean areAllConquered = false;
        for (int i = 0; i < 7; i++) {
            int sum = 0;
            sum += dailyFood.pop() + dailyStamine.poll();

            if(counter < peaks.size()) {
                String[] peakData = peaks.get(counter).split(" - ");
                int difficultyLevel = Integer.parseInt(peakData[1]);
                if(sum < difficultyLevel) {
                    continue;
                }
                counter++;
            }

            if(counter == peaks.size()) {
                areAllConquered = true;
                break;
            }
        }

        if(counter == peaks.size()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if(counter > 0) {
            System.out.println("Conquered peaks: ");
            for (int i = 0; i < counter; i++) {
                String peakName = peaks.get(i).split(" - ")[0];
                System.out.println(peakName);
            }
        }

    }
}
