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
			
			//This section asks for users account information, then checks to see if they are in our system
			System.out.println("Please enter your Account number");
			int accountNumberIn = sc.nextInt();
			System.out.println("Please enter your pin number");
			int pinIn = sc.nextInt();	
			int positionAccount = Person.checkAccount(accountNumberIn, account);
			int positionPin = Person.checkPin(pinIn, account);
			
			if((positionAccount == -1) || (positionPin == -1)) {
				System.out.println("Either your credentals were not correct, or your account does not exist");
				System.out.println("Please try again");
				System.exit(0);
			}
		
			Person personalAccount = account.get(positionAccount);
			personalAccount.showBalance(0);
		
			try {
				//gives options to what the user would like to do	
				boolean escape = true;
					while(escape != false) {
						System.out.println("Do you want to deposit[1], withdrawl[2], or end[3]?");
						int decision = sc.nextInt();
						//deposit money 
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
								System.out.printf("Your current amount is $" + "%.2f" + "\n", personalAccount.balance);
								
							}
			
						//withdrawl money
						}else if(decision == 2) {
							//execute withdrawl method
							System.out.println("How much would you like to withdraw?");
							float withdrawl = sc.nextFloat();
							if(withdrawl < 0) {
								System.out.println("Invalid input, please correct");
								System.out.println("");
							}else {
								Person withdrawling = new withdrawl(personalAccount.accountNumber, personalAccount.pin, personalAccount.balance);
								float remaninder = withdrawling.showBalance(withdrawl);
								personalAccount.balance = remaninder; 
								System.out.printf("Your current amount is $" + "%.2f" + "\n", personalAccount.balance);
							}	
							//exit loop. they do not want to do anything 
						}else if(decision == 3 ) {
							escape = false;
						
						}else {
							// the input is incorrect
							System.out.print("Wrong input, try again");
							System.out.println("");
						}
					}	
				
			}catch (Exception e){
				System.out.print("Wrong input, please rerun program");
				System.exit(0);
			}
		
		//export the project in the file
			Person.exporting(account);
			System.out.println("Thank you for using our ATM!");
			
			} catch (Exception e) {
				System.out.println("There was an input error, please try again with only integers");
				System.exit(0);
			}
		}
	

}
