package atmPages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Person {
	
	public int accountNumber;
	private int pin;
	private float balance;
	
	public Person(int accountNumber, int pin, float balance){
		
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
		
	}
	
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
	
	public static void exporting(ArrayList<Person> accounts) {

		File file = new File("C:\\Users\\matto\\eclipse-workspaceNEW\\oopATMgithub\\exporting.txt");
		
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
	
	public void showBalance(Person person) {
		System.out.print("You have $" + person.balance + "in your bank account");
	
	}
	public static int checkAccount(int accountNumberIn, ArrayList<Person> accountArray) {
		for(int i = 0; i < accountArray.size(); i++) {
			Person temp = accountArray.get(i);
			if(temp.accountNumber == accountNumberIn) {
				return i;
			}
		}	
		return -1;
	}
	
	public static int checkPin(int pinNumberIn, ArrayList<Person> accountArray) {
		for(int i = 0; i < accountArray.size(); i++) {
			Person temp = accountArray.get(i);
			if(temp.pin == pinNumberIn) {
				return i;
			}
		}	
		return -1;
	}
	
	
}
