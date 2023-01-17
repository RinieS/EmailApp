import java.util.Scanner;

public class Email {

	private String email;
	private String firstName;
	private String lastName;
	private String password; 
	private String dep;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPassLength= 8;
	private String companySuffix = "company.com";
	
	//constructor (firstName, lastName)
	
	public Email(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
		
		
		this.dep = setDepartment();
		//call method to generate a random password 
		this.password = randomPassword(defaultPassLength);
		System.out.println("Password: "+ this.password);
		
		//generate email 
		email= firstName.toLowerCase() + "."+ lastName.toLowerCase() + "@"+ dep +"."+ companySuffix;

	}
	
	// get department (dep)
	private String setDepartment () {
		System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if (choice == 1) {return "Sales";}
		else if(choice == 2) {return "Development";}
		else if(choice==3) {return "Accounting";}
		else {return "";}
	}
	
	//generate password
	private String randomPassword (int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?#@%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int randValue=(int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(randValue);
		}
		
		return new String(password);
	}
	
	//set mailbox capacity
	public void setmailboxCapacity (int newCapacity) {
		this.mailboxCapacity = newCapacity;
	}
	//set the alternate email
	public void setAltEmail (String altEmail) {
		this.alternateEmail = altEmail;
	}
	//change password 
	
	public void changePassword (String newPass) {
		this.password = newPass;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAltEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "Display name: " +firstName + " " + lastName +
				"\nCompany email: "+ email +
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
