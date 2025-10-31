package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

	// Main Class
public class BankManagementSystem {
		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			AccountManager manager = new AccountManager();

			while (true) {

			System.out.println("\n-Account Management System -");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer");
			System.out.println("5. Show Account");
			System.out.println("6. Show All Accounts");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
			System.out.print("Enter Account No: ");
			String accNo=sc.next();
			
			sc.nextLine(); // consume leftover newline
			
			System.out.print("Enter Holder Name: ");
			String name=sc.nextLine(); // changed to nextLine()
			
			System.out.print("Enter Initial Balance: ");
			double bal=sc.nextDouble();

			manager.createAccount(accNo, name, bal);

			break;

			case 2:

			System.out.print("Enter Account No: ");

			accNo=sc.next();

			System.out.print("Enter Amount to Deposit: ");

			double dep=sc.nextDouble();

			manager.deposit (accNo, dep);

			break;

			case 3:

			System.out.print("Enter Account No: ");

			accNo=sc.next();

			System.out.print("Enter Amount to Withdraw: ");

			double wd= sc.nextDouble();

			manager.withdraw (accNo, wd);

			break;
			
			case 4:
			System.out.print("Enter Source Account No: ");

			String from = sc.next();

			System.out.print("Enter Destination Account No: ");

			String to = sc.next();

			System.out.print("Enter Amount to Transfer: ");

			double amt = sc.nextDouble();

			manager.transfer (from, to, amt);

			break;

			case 5:

			System.out.print("Enter Account No: ");

			accNo=sc.next();

			manager.showAccount (accNo);

			break;

			case 6:

			manager.showAllAccounts();

			break;

			case 7:

			System.out.println("Exiting... Goodbye!");

			sc.close();

			return;

			default:

			System.out.println("Invalid choice!");
			}
			}
		}
	}
	class Account {

		private String accountNumber;

		private String holderName;

		private double balance;

		public Account (String accountNumber, String holderName, double balance) {

		this.accountNumber=accountNumber;

		this.holderName=holderName;

		this.balance=balance;

		}

		// Getters

		public String getAccountNumber() {

			return accountNumber;

		}

		public String getHolderName() {

			return holderName;

		}

		public double getBalance() {

			return balance;

		}

		// Deposit money

		public void deposit (double amount) {
			if(amount>0) {
				balance+=amount;
				System.out.println("Deposited: "+amount);
			}
		else
			System.out.println("Invalid deposit amount!");
		}
		
		// Withdraw money

		public void withdraw(double amount) {

		if (amount > 0 && amount <=balance) {

		balance-=amount;

		System.out.println("Withdrawn: " + amount);

		} else {

		System.out.println("Insufficient funds or invalid amount!");

		}

		}

		// Display account details

		public void displayDetails() {

		System.out.println("Account No: + accountNumber +| Holder: " + holderName + " | Balance: " + balance);

		}

	}

	// AccountManager class

	class AccountManager {

		private Map<String, Account> accounts = new HashMap<>();

		// Create account

		public void createAccount(String accNo, String holderName, double balance) {

			if (accounts.containsKey(accNo)) {

				System.out.println("Account already exists!");

			} else {

				accounts.put(accNo, new Account(accNo, holderName, balance));

				System.out.println("Account created successfully!");

			}

		}

		// Deposit

		public void deposit(String accNo, double amount) {

		Account acc=accounts.get(accNo);

		if (acc!=null)

		acc.deposit(amount);

		else

		System.out.println("Account not found!");

		}
		// Withdraw

		public void withdraw (String accNo, double amount) {

		Account acc=accounts.get(accNo);

		if (acc!=null)

		acc.withdraw (amount);

		else

		System.out.println("Account not found!");

		}

		// Transfer

		public void transfer (String fromAcc, String toAcc, double amount) {

		Account from=accounts.get(fromAcc);

		Account to=accounts.get(toAcc);

		if (from!=null && to!=null) {

		if (from.getBalance()>=amount) {

		from.withdraw(amount);

		to.deposit(amount);

		System.out.println("Transferred + amount from fromAceto"+toAcc);

		} else {

		}

		System.out.println("Insufficient funds in source account!");

		}else{

			System.out.println("One or both accounts not found!");

		}

	}

	// Show account details

	public void showAccount(String accNo) {

		Account acc=accounts.get(accNo);

		if (acc!=null)

		acc.displayDetails();

		else

		System.out.println("Account not found!");

		}

	// Show all accounts

	public void showAllAccounts() {

		if (accounts.isEmpty()) {

		System.out.println("No accounts available!");

		} else {

		for (Account acc:accounts.values()) {

		acc.displayDetails();

		}
	 }
  }
}


