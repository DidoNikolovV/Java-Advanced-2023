package _05_Border_Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiable = new ArrayList<>();
        Identifiable identifiableObject = null;
        while(!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            if(tokens.length == 2) {
                identifiableObject = new Robot(tokens[0], tokens[1]);
            } else if(tokens.length == 3) {
                identifiableObject = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            identifiable.add(identifiableObject);

            line = scanner.nextLine();
        }

        String lastDigitOfFakeIds = scanner.nextLine();

        for (Identifiable obj : identifiable) {
            String currentId = obj.getId();
            String lastThreeDigits = currentId.substring(currentId.length() -3);
            if(lastThreeDigits.equals(lastDigitOfFakeIds)) {
                System.out.println(currentId);
            }
        }
    }
}
