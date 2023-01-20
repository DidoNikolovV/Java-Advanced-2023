package FixEmails;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsInfo.put(name, email);
            }

            input = scanner.nextLine();
        }

        for(var entry: emailsInfo.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
