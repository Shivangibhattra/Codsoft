import java.util.Scanner;

public class ATM {

    private int balance = 10000; // Initial balance set to $10000
    private Scanner scanner;

    public ATM() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("========== ATM Menu ==========");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("===============================");
    }

    public void withdrawCash() {
        System.out.println("Enter amount to withdraw:");
        int amount = scanner.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Please collect your cash.");
        }
    }

    public void depositCash() {
        System.out.println("Enter amount to deposit:");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Deposit successful.");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}