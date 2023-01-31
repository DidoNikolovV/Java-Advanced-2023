package BankAccount;

public class BankAccount {
    private int id;
    private static int bankAccountCount = 1;
    private double balance;
    private static double INTEREST_RATE = 0.02;

    public BankAccount(){
        this.id = bankAccountCount++;
    };
    public static void setInterestRate(double interest) {
        INTEREST_RATE = interest;
    }

    public double getInterest(int years) {
        return BankAccount.INTEREST_RATE * years * this.balance;
    }

    public int getId() {
        return this.id;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
