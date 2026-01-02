package polymorphism;

/**
 * SavingsAccount class
 * 
 * @author Mark Yan
 * @version 10.06.25
 * 
 */

public class SavingsAccount extends BankAccount{

	private static final double INTEREST_RATE = .055;
	
	/**
	 * Constructor for a SavingsAccount object
	 * 
	 * @param number
	 * @param holder
	 * @param total
	 */
	
	public SavingsAccount(String number, String holder, double total) {
		super(number, holder, total);
	}
	
	/**
	 * Calculates interest earned on the account
	 * 
	 * @return the interest earned
	 */
	
	@Override
	public String calculateInterest() {
		double interest_amount = balance * INTEREST_RATE;
		
		String output = String.valueOf(interest_amount);
		
		return output;
	}


}
