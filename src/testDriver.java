import java.io.FileNotFoundException;
import java.util.*;
import atmPages.*;

public class testDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// import file
		ArrayList<Person> account = Person.importing();
		
		//ask for user account + pin
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Please enter you Account number");
			int accountNumberIn = sc.nextInt();
			System.out.println("Pleas enter you pin number");
			int pinIn = sc.nextInt();	
			//check if account number 
			int positionAccount = Person.checkAccount(accountNumberIn, account);
			int positionPin = Person.checkPin(pinIn, account);
			
			if((positionAccount != -1) || (positionPin != -1)) {
				System.out.println("Either your accountNumber or Pin does not match or exist");
		}
		
			//ask what they want to do? check or deposit or end
			System.out.println("Do you want to deposit[1], withdrawl[2], or end[3]?");
			try {
				int decision = sc.nextInt();
				boolean x = true;
				while(x != false) {
					if(decision == 1) {
					
					}else if(decision == 2) {
					
					}else if(decision == 3 ) {
						x = false;
					}else {
						System.out.print("Wrong input, try again");
					}
				}
				
			}catch (Exception e){
				System.out.print("Wrong input, please rerun program");
			}
		
		//Change account information in the arraylist
		
		//export file
			Person.exporting(account);
			} catch (Exception e) {
				System.out.println("There was an input error, please enter and integer");
			}
		}
	

}
