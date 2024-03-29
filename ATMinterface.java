import java.util.Scanner;

// Bank Account class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

// ATM class
public class ATMinterface {
    private BankAccount account; // Reference to the user's bank account
    private Scanner sc; // Scanner object for user input

    public ATMinterface(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        if (sc.hasNextDouble()) {
            double depositAmount = sc.nextDouble();
            if (depositAmount > 0) {
                account.deposit(depositAmount);
                System.out.println("You deposited: " + depositAmount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // consume the invalid input
        }
    }

    public void withdraw() {
        System.out.println("Enter the amount you want to withdraw:");
        if (sc.hasNextDouble()) {
            double withdrawAmount = sc.nextDouble();
            if (withdrawAmount > 0) {
                boolean success = account.withdraw(withdrawAmount);
                if (success) {
                    System.out.println("You have withdrawn: " + withdrawAmount);
                } else {
                    System.out.println("Insufficient balance");
                }
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // consume the invalid input
        }
    }

    public void checkBalance() {
        System.out.println("Your Current balance is " + account.getBalance());
    }

    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(1000); // Initialize with initial balance
        ATMinterface atm = new ATMinterface(userAccount);

        while (true) {

            System.out.println(" ___________________________________________________");
            System.out.println("|                                                   |");
            System.out.println("|               W E L C O M E   S I R               |");
            System.out.println("|                                                   |");
            System.out.println("|         ..................................        |");
            System.out.println("|         :                                :        |");
            System.out.println("|         :     PRESS 1 TO DEPOSIT         :        |");
            System.out.println("|         :     PRESS 2 TO WITHDRAW        :        |");
            System.out.println("|         :     PRESS 3 TO CHECK BALANCE   :        |");
            System.out.println("|         :     PRESS 4 TO EXIT            :        |");
            System.out.println("|         :................................:        |");
            System.out.println("|                                                   |");
            System.out.println("|                                                   |");
            System.out.println("|___________________________________________________|");

            int choice = atm.sc.nextInt(); // Read user's choice

            switch (choice) {
                case 1:
                    atm.deposit();
                    break;
                case 2:
                    atm.withdraw();
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    atm.sc.close(); // Close Scanner before exiting the program
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
