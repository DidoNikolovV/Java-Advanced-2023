package PhoneBook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("search")) {
            String[] inputParts = input.split("-");
            String name = inputParts[0];
            String phoneNumber = inputParts[1];

            phoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!input.equals("stop")) {
            String searchedName = input;
            if(phoneBook.containsKey(searchedName)) {
                System.out.println(searchedName + " -> " + phoneBook.get(searchedName));
            } else {
                System.out.println("Contact " + searchedName + " does not exist.");
            }

            input = scanner.nextLine();
        }


    }
}
