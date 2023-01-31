package BankAccount;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<Integer, BankAccount> bankAccounts = new LinkedHashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.#####");
        while(!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if(command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());;
            } else if(command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                double amount = Double.parseDouble(tokens[2]);
                if(!bankAccounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    bankAccounts.get(id).deposit(amount);
                    System.out.printf("Deposited %s to ID%d%n", decimalFormat.format(amount), id);
                }

            } else if(command.equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                if(!bankAccounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
                }
            } else if(command.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);
            }

            input = scanner.nextLine();
        }
    }
}
