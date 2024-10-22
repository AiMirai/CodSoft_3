import java.util.Scanner;

// BankAccount class to store and manage account balance
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful! Your new balance is: $" + balance;
        } else {
            return "Invalid deposit amount. Please enter a positive value.";
        }
    }

    // Method to withdraw money from the account
    public String withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return "Withdrawal successful! Your new balance is: $" + balance;
            } else {
                return "Insufficient funds. Your current balance is: $" + balance;
            }
        } else {
            return "Invalid withdrawal amount. Please enter a positive value.";
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class to manage ATM operations
class ATM {
    private BankAccount account;

    // Constructor to link the ATM to a specific bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display options and manage user inputs
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Check balance
                    System.out.println("Your current balance is: $" + account.checkBalance());
                    break;
                case 2:
                    // Deposit money
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                    break;
                case 3:
                    // Withdraw money
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
            System.out.println();
        } while (option != 4);

        scanner.close();
    }
}

// Main class to run the ATM
public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(500.00);

        // Create an ATM and link it to the bank account
        ATM atm = new ATM(account);

        // Start the ATM
        atm.start();
    }
}
