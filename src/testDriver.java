import java.io.FileNotFoundException;
import java.util.*;
import atmPages.*;

public class testDriver {

	public static void main(String[] args) {
		
		//dpme
		ArrayList<Person> account = Person.importing();
		
		//dpme
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Please enter you Account number");
			int accountNumberIn = sc.nextInt();
			System.out.println("Please enter you pin number");
			int pinIn = sc.nextInt();	
			int positionAccount = Person.checkAccount(accountNumberIn, account);
			int positionPin = Person.checkPin(pinIn, account);
			
			if((positionAccount == -1) || (positionPin == -1)) {
				System.out.println("Either your credentals were not correct, or your account does not exist");
				System.out.println("Please Try Again");
				System.exit(0);
			}
		
			Person personalAccount = account.get(positionAccount);
			personalAccount.showBalance(0);
		
			try {
					boolean escape = true;
					while(escape != false) {
						System.out.println("Do you want to deposit[1], withdrawl[2], or end[3]?");
						int decision = sc.nextInt();
						//deposit
						if(decision == 1) {
							//execute deposit method
							System.out.println("How much would you like to deposit?");
							float depo = sc.nextFloat();
							if(depo < 0) {
								System.out.println("Invalid input, please correct");
								System.out.println("");
								
							}else {
								Person depositing = new deposit(personalAccount.accountNumber, personalAccount.pin, personalAccount.balance);
								float remainder = depositing.showBalance(depo);
								personalAccount.balance = remainder;
								System.out.println("You current amount is $" + personalAccount.balance);
								
							}
			
						//withdrawl
						}else if(decision == 2) {
							//execute withdrawl method
							System.out.println("How much would you like to withdrawl?");
							float withdrawl = sc.nextFloat();
							if(withdrawl < 0) {
								System.out.println("Invalid input, please correct");
								System.out.println("");
							}else {
								Person withdrawling = new withdrawl(personalAccount.accountNumber, personalAccount.pin, personalAccount.balance);
								float remaninder = withdrawling.showBalance(withdrawl);
								personalAccount.balance = remaninder; 
								System.out.println("You current amount is $" + personalAccount.balance);
							}	
							//exit
						}else if(decision == 3 ) {
							escape = false;
						
						}else {
							System.out.print("Wrong input, try again");
							System.out.println("");
						}
					}	
				
			}catch (Exception e){
				System.out.print("Wrong input, please rerun program");
				System.exit(0);
			}
		
		//done
			Person.exporting(account);
			System.out.println("Thank you for using our ATM!");
			
			} catch (Exception e) {
				System.out.println("There was an input error, Please try again with only integers");
				System.exit(0);
			}
		}
	

}
