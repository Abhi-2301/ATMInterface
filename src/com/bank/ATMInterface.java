package com.bank;

import java.util.Scanner;


class BankAccount {

	private double balance;
	
	

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance += amount;
			System.out.println("Deposit of $ " +amount+ "successful.Current balance: $ " +balance);
			
		}
		else
		{
			System.out.println("Invalid Deposit Amount");
			
		}
	}
	public void withDraw(double amount)
	{
		if(amount>0 && amount<=balance)
		{
			balance -= amount;
			System.out.println("withdeawl of $"+amount+" succesful");
			System.out.println("current balance is: "+balance);
		}
		else
		{
			System.out.println("Invalid Withdrawl Amount or Insufficient Balance");
		}
	}
}
 class ATM {

	private BankAccount account;

	public ATM(BankAccount account) {
		super();
		this.account = account;
	}
	
	public void displayMenu()
	{
		System.out.println("ATM Menu: ");
		System.out.println("1.Check Balance");
		System.out.println("2.Deposit Money");
		System.out.println("3.Withdraw Money");
		System.out.println("4.Exit");
	}
	public void performTransaction(int choice,Scanner sc)
	{
		switch(choice)
		{
		case 1:
			System.out.println("Current Balance is: "+account.getBalance());
			break;
		case 2:
			System.out.println("Enter Deposit Amount");
			double depositamount=sc.nextDouble();
			account.deposit(depositamount);
			break;
		case 3:
			System.out.println("Enter Withdraw Amount");
			double withdrawalAmount=sc.nextDouble();
			account.withDraw(withdrawalAmount);
			break;
		case 4:
			System.out.println("Existing ATM.Thank You");
			sc.close();
			System.exit(0);
		default:
			System.out.println("Invalid Choice.Please Select a valid option");
		}
	}
}


public class ATMInterface {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to ATM");
		System.out.println("Enter the Initial Account Balance");
		double initialBalance=sc.nextDouble();
		
		BankAccount ba=new BankAccount(initialBalance);
		
		ATM atm=new ATM(ba);
		while(true)
		{
			atm.displayMenu();
			System.out.println("Select an Option");
			int choice=sc.nextInt();
			
			atm.performTransaction(choice, sc);
		}
		
		
	}
}
