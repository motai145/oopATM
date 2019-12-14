package atmPages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Person {
	
	public int accountNumber;
	public int pin;
	public float balance;
	
	public Person(int accountNumber, int pin, float balance){
		
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
		
	}
	
	//imports the list from the textfile
	//returns the the information into an arraylist
	public static ArrayList<Person> importing(){
		
		File file = new File("C:\\Users\\matto\\eclipse-workspaceNEW\\oopATMgithub\\importing.txt");
		Scanner sc;
		ArrayList<Person> accounts = new ArrayList<Person>();
		
		try {
			sc = new Scanner(file);
			
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String []row = data.split(",");
				
				int accountNumberr;
				int pinn;
				float balancee;
			
				accountNumberr = Integer.parseInt(row[0]);
				pinn = Integer.parseInt(row[1]);
				balancee = Float.parseFloat(row[2]);
				
				Person temp = new Person(accountNumberr,pinn,balancee);
				accounts.add(temp);
				
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
		
			System.out.print(e);
		}
		
			return accounts;
	}
	
	//exports the file to the importing.txt file to update the withdrawl amount
	
	public static void exporting(ArrayList<Person> accounts) {

		File file = new File("C:\\Users\\matto\\eclipse-workspaceNEW\\oopATMgithub\\importing.txt");
		
		try {
			
			FileWriter writer = new FileWriter(file);
			
			for(int i = 0; i < accounts.size(); i++) {
				Person tempStudent = accounts.get(i);
				
				writer.write(tempStudent.accountNumber + "," + tempStudent.pin+ "," + tempStudent.balance + "\n");
				
				writer.flush();
			}
			
			writer.close();
			
		} catch (IOException e) {
			
			System.out.println("Couldnt Write");
		}
	}

	//method to check if the account number the user inputed is in our system
	public static int checkAccount(int accountNumberIn, ArrayList<Person> accountArray) {
		for(int i = 0; i < accountArray.size(); i++) {
			Person temp = accountArray.get(i);
			if(temp.accountNumber == accountNumberIn) {
				return i;
			}
		}	
		return -1;
	}
	
	//method to check if the pin is in the array list
	//this does not check to see if they match, only to see if they exist
	public static int checkPin(int pinNumberIn, ArrayList<Person> accountArray) {
		for(int i = 0; i < accountArray.size(); i++) {
			Person temp = accountArray.get(i);
			if(temp.pin == pinNumberIn) {
				return i;
			}
		}	
		return -1;
	}
	
	//method to show the current balance in the users account 
	public float showBalance(float amount) {
		//You currently have this much in your account 
		System.out.println("You currently have $" + this.balance + " in your account");
		
		return 0;
		
	}

	
}
