package builderExercise;

import java.util.Scanner;

public class Main {
    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = readContactInfo(scanner);

        // TODO:

    }

    private static Contact readContactInfo(Scanner input) {
        Contact.Builder builder = new Contact.Builder();

        System.out.print("Name: ");
        builder.setName(input.nextLine());

        System.out.print("Number: ");
        builder.setNumber(input.nextLine());

        System.out.print("Company: ");
        builder.setCompany(input.nextLine());

        System.out.print("Title: ");
        builder.setTitle(input.nextLine());

        System.out.print("Email: ");
        builder.setEmail(input.nextLine());

        System.out.print("Website: ");
        builder.setWebsite(input.nextLine());

        System.out.print("Birthday: ");
        builder.setBirthday(input.nextLine());

        return builder.build();
    }
}
