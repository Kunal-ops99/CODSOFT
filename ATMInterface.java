import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = getInputInt("Choose an option: ");

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3:
                    withdrawAmount();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Please select from 1 to 4.");
            }

        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\n======== ATM MENU ========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("==========================");
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.printf("Your current balance is: ₹%.2f\n", balance);
    }

    private void depositAmount() {
        double amount = getInputDouble("Enter amount to deposit: ₹");
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited ₹%.2f\n", amount);
        } else {
            System.out.println("Deposit failed. Please enter a valid amount.");
        }
    }

    private void withdrawAmount() {
        double amount = getInputDouble("Enter amount to withdraw: ₹");
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrawn ₹%.2f\n", amount);
        } else {
            System.out.println("Withdrawal failed. Either insufficient balance or invalid amount.");
        }
    }

   
    private double getInputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // discard invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    private int getInputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.next(); // discard invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}


public class ATMInterface {
    public static void main(String[] args) {
        System.out.println("===== Welcome to the ATM Interface =====");
        BankAccount userAccount = new BankAccount(1000); // initial balance ₹1000
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}
