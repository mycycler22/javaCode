package polymorphism;

public class BankMain {
	public static void main(String[] args) {
        // Creating an instance of SavingsAccount
        BankAccount savingsAccount = new SavingsAccount("S123", "Alice", 1000);

        // Operations on the savings account
        System.out.println(savingsAccount.deposit(200)); // Deposit money
        System.out.println(savingsAccount.withdraw(150)); // Withdraw money
        System.out.println("Interest: " + savingsAccount.calculateInterest()); // Calculate interest

        // Creating an instance of CheckingAccount
        BankAccount checkingAccount = new CheckingAccount("C456", "Bob", 500);

        // Operations on the checking account
        System.out.println(checkingAccount.deposit(300)); // Deposit money
        System.out.println(checkingAccount.withdraw(100)); // Withdraw money
        System.out.println("Interest: " + checkingAccount.calculateInterest()); // Calculate interest

        // Display account details
        System.out.println(savingsAccount); // Display savings account details
        System.out.println(checkingAccount); // Display checking account details
    }

}

