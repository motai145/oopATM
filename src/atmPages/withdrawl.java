package atmPages;

public class withdrawl extends Person {

	public withdrawl(int accountNumber, int pin, float balance) {
		super(accountNumber, pin, balance);
		// TODO Auto-generated constructor stub	
	}
	
	public float showBalance(float amount) {
		float remainder = this.balance - amount;
		
		return remainder;
	
	}

}
