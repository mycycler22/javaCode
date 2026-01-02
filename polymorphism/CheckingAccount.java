package polymorphism;

/**
 * CheckingAccount class
 * 
 * @author Mark Yan
 * @version 10.06.25
 * 
 */


public class CheckingAccount extends BankAccount{
	
	private static final double INTEREST_RATE = .01;
	
	/**
	 * Constructor for a CheckingAccount object
	 * 
	 * @param number
	 * @param holder
	 * @param total
	 */
	
	public CheckingAccount(String number, String holder, double total) {
		super(number, holder, total);
	}

	/**
	 * Returns the interest gained on the account
	 * 
	 * @return interest gained on the account
	 */
	
	@Override
	public String calculateInterest() {
		double interest = balance * INTEREST_RATE;
		
		String output = String.valueOf(interest);
		
		return output;
	}
	
}
