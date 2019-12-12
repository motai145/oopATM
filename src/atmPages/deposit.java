package atmPages;

public class deposit extends Person {

	public deposit(int accountNumber, int pin, float balance) {
		super(accountNumber, pin, balance);
		// TODO Auto-generated constructor stub
	}
	
	public float showBalance(float amount) {
		float remainder = this.balance + amount;
		
		return remainder;
	}

}
