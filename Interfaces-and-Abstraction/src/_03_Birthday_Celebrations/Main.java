package _03_Birthday_Celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Birthable> haveBirthdate = new ArrayList<>();
        Birthable haveBirthdateObj;
        while(!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String type = commandParts[0];
            switch(type) {
                case "Citizen":
                    haveBirthdateObj = new Citizen(commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3], commandParts[4]);
                    break;
                case "Robot":
                    haveBirthdateObj = null;
                    break;
                case "Pet":
                    haveBirthdateObj = new Pet(commandParts[1], commandParts[2]);
                    break;
                default:
                    throw new IllegalStateException("Invalid command " + command);
            }
            if(haveBirthdateObj != null) {
                haveBirthdate.add(haveBirthdateObj);
            }
            command = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        for (Birthable birthable : haveBirthdate) {
            if(birthable.getBirthDate().endsWith(specificYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
