package atmPages;

public class withdrawl extends Person {

	//inherited constructor 
	public withdrawl(int accountNumber, int pin, float balance) {
		super(accountNumber, pin, balance);
		// TODO Auto-generated constructor stub	
	}
	
	//inherited method to show balance when a user withdrawls money
	public float showBalance(float amount) {
		float remainder = this.balance - amount;
		
		return remainder;
	
	}

}
