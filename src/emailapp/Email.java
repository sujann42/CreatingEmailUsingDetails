package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 12;
	private String companydomain = "trades.com";

	// Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		

		// Call a method asking for department
		this.department = setDepartment();
		

		// Create random password
		this.password = generateRandomPassword(defaultPasswordLength);
		

		// Combine info to get email
		email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "."
				+ companydomain;
		
	}

	// Ask for department
	private String setDepartment() {
		System.out.println(
				"New Worker: "+this.firstName+". Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department: ");
		Scanner sc = new Scanner(System.in);
		int departmentChoice = sc.nextInt();
		switch (departmentChoice) {
		case 1:
			return "sales";
		case 2:
			return "development";
		case 3:
			return "accounting";
		case 0:
			return "none";
		default:
			return "";
		}

	}

	// Generate random password
	private String generateRandomPassword(int length) {

		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@_#?$!";
		char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			int num = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(num);
		}

		return new String(password);
	}

	// Set Mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set alternative email
	public void setAlternativeEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change password
	public void changePassword(String password) {
		this.password = password;
	}

	// Getter for mailbox capacity
	public int getMailBoxCapacity() {
		return mailboxCapacity;
	}

	// Getter for alternate Email
	public String getAlternateEmail() {
		return alternateEmail;
	}

	// Getter for password
	public String getPassword() {
		return password;
	}
	
	public String displayInfo() {
		
		String details = "Name: "+this.firstName+" "+this.lastName
						 +"\nCompany Email: "+this.email
						 +"\nMailBox Capacity: "+this.mailboxCapacity +"MB"
						 +"\nALternate Email: "+this.alternateEmail;
						 ;
		
		return details;
		
	}

}
