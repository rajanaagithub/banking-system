import java.util.Scanner;

// BankAccount class (OOP)
class BankAccount {
    private final String name;
    private final int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid amount!");
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println(" Withdrawn: " + amount);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println(" Current Balance: " + balance);
    }

    // Display account details
    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
    }
}

// Main class
public class BankApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Create account
            System.out.println(" Welcome to Banking System");
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            BankAccount user = new BankAccount(name, accNo);
            user.displayDetails();

            int choice;

            // Menu loop
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        user.deposit(depositAmount);
                    }

                    case 2 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        user.withdraw(withdrawAmount);
                    }

                    case 3 -> user.checkBalance();

                    case 4 -> System.out.println("Thank you for using our banking system!");

                    default -> System.out.println(" Invalid choice! Try again.");
                }

            } while (choice != 4);
        }
    }
}