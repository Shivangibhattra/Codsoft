import java.util.*;
public class ATMInterface {
    
    private BankAccount account;

    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Automated Teller Machine");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        switch (choice) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting ATM...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void withdraw() {
        System.out.println("Enter amount to withdraw:");
        double amount = Scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void deposit() {
        System.out.println("Enter amount to deposit:");
        double amount = Scanner.nextDouble();

        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATMInterface atm = new ATMInterface(account);

        while (true) {
            atm.displayMenu();
            int choice = Scanner.nextInt();
            atm.performTransaction(choice);
        }
    }
