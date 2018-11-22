package bankaccountapp;

public abstract class Account implements IBaseRate {
	//List common properties for savings and checking accounts
	private String name;
	private String sSN;
	protected String accountNumber;
	private static int index = 10000;
	
	private double balance;
	protected double rate;
	
	//Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit, int type) { //type: 1 for Savings or 2 for Checking account
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;

		//Set account number
		this.accountNumber = type + setAccountNumber();
	}
	
	//List common methods - transactions
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited $" + amount);
		showBalance();
	}
	
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Withdrawed $" + amount);
		} else System.err.println("\nX Transactions Failed X\nThe current account balance is less than $" + amount + "\n");
		showBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Transfering $" +amount+ "to " +toWhere);
		} else System.err.println("\nX Transactions Failed X\nThe current account balance is less than $" + amount + "\n");
		showBalance();
	}
	
	private void showBalance() {
		System.out.println("Your balance is: $" + balance);
	}
	
	public abstract void setRate();
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		showBalance();
	}
	
	private String setAccountNumber() {
		String lastTwoOfSSN = this.sSN.substring(sSN.length()-2, sSN.length());
		index++;
		int threeRandomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + index + threeRandomNumber;
	}
	
	public void showInfo() {
		System.out.println("***********************************");
		System.out.println("NEW ACCOUNT: " );
		System.out.println( "NAME: " + name + 
							"\nSSN: " + sSN + 
							"\nACCOUNT NUMBER: " + accountNumber + 
							"\nBALANCE: $" + balance +
							"\nRATE: " + rate + "%");
	}

}
