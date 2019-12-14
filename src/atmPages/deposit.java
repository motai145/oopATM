package atmPages;

public class deposit extends Person {

	//inherited constructor 
	public deposit(int accountNumber, int pin, float balance) {
		super(accountNumber, pin, balance);
		// TODO Auto-generated constructor stub
	}
	
	//inherited method to show balance when a user deposits money
	public float showBalance(float amount) {
		float remainder = this.balance + amount;
		
		return remainder;
	}

}
