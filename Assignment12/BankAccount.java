package Assignment12;

public class BankAccount {

    private int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    private double interestRate;
    private static String accountType = "Savings Account";

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: " + accountType);
    }
}

class CheckingAccount extends BankAccount {

    private int withdrawalLimit;
    private static String accountType = "Checking Account";

    CheckingAccount(int accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }


    public void displayAccountType() {
        System.out.println("Account Type: " + accountType);
    }
}

class FixedDepositAccount extends BankAccount {

    private int fdAmount;
    private static String accountType = "FD Account";

    FixedDepositAccount(int accountNumber, double balance, int fdAmount) {
        super(accountNumber, balance);
        this.fdAmount = fdAmount;
    }


    public void displayAccountType() {
        System.out.println("Account Type: " + accountType);
    }
}
