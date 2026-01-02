package polymorphism;
/**
 * BankAccount class
 * 
 * @author Mark Yan
 * @version 10.06.25
 * 
 */


public abstract class BankAccount {
	
	protected String accountNumber;
	protected String accountHolder;
	protected double balance;
	
	/**
	 * Constructor for a BankAccount object
	 * 
	 * @param number
	 * @param holder
	 * @param total
	 */
	
	public BankAccount(String number, String holder, double total) {
		this.accountNumber = number;
		this.accountHolder = holder;
		this.balance = total;
	}
	
	/**
	 * Getter method for the Account number
	 * 
	 * @return account number
	 */
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Getter method for the holder
	 * 
	 * @return the name of the account holder
	 */
	
	public String getHolder() {
		return accountHolder;
	}
	
	/**
	 * Getter method for the balance of the account
	 * 
	 * @return the balance of the account
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Deposit method
	 * 
	 * @param amount
	 * @return Transaction summary
	 */
	public String deposit(double amount) {
		balance+=amount;
		
		return "Deposit successful. New balance: " + balance;
	}
	
	/**
	 * Withdraw method
	 * 
	 * @param amount
	 * @return Transaction Summary
	 */
	public String withdraw(double amount) {
		double preBalance = getBalance();
		double newBalance = balance-=amount;
		
		if(newBalance < 0) {
			newBalance = preBalance;
			return "Withdrawal Unsuccessful: Insufficient funds";
		}
		
		return "Withdrawal Successful. New balance: " + balance;		
		
		
	}
	
	public abstract String calculateInterest();
	
	
	
	public String toString() {
		return "Account Number: " + accountNumber + "\n" +
		"Account Holder: " + accountHolder + "\n" +
		"Balance: " + balance;
	}

}
