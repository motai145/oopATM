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
			//check if account number 
			int positionAccount = Person.checkAccount(accountNumberIn, account);
			int positionPin = Person.checkPin(pinIn, account);
			
			if((positionAccount == -1) || (positionPin == -1)) {
				System.out.println("Either your credentals were not correct, or your account does not exist");
				System.out.println("Please Try Again");
				System.exit(0);
			}
		
			Person personalAccount = account.get(positionAccount);
			personalAccount.showBalance(0);
			System.out.println("Do you want to deposit[1], withdrawl[2], or end[3]?");
			
			//ask what they want to do? check or deposit or end
			try {
				int decision = sc.nextInt();
				boolean x = true;
				while(x != false) {
					boolean escape = true;
					while(x != false) {
						//deposit
						if(decision == 1) {
							//execute deposit method
							System.out.println("How much would you like to deposit?");
							float depo = sc.nextFloat();
							Person depositing = new deposit(personalAccount.accountNumber, personalAccount.pin, personalAccount.balance);
							depositing.showBalance(depo);
							System.out.println("You current amount is $" + personalAccount.balance);
							break;
							
						//withdrawl
						}else if(decision == 2) {
							//execute withdrawl method
							System.out.println("How much would you like to withdrawl?");
							float withdrawl = sc.nextFloat();
							Person withdrawling = new withdrawl(personalAccount.accountNumber, personalAccount.pin, personalAccount.balance);
							withdrawling.showBalance(withdrawl);
							System.out.println("You current amount is $" + personalAccount.balance);
							break;
							
						//exit
						}else if(decision == 3 ) {
						x = false;
						
						}else {
							System.out.print("Wrong input, try again");
						}
					}
				}	
				
			}catch (Exception e){
				System.out.print("Wrong input, please rerun program");
			}
		
		//Change account information in the arraylist
		
		//done
			Person.exporting(account);
			System.out.println("Thank you for using our ATM!");
			
			} catch (Exception e) {
				System.out.println("There was an input error, Please try again with only integers");
				System.exit(0);
			}
		}
	

}
