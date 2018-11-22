package bankaccountapp;

public class Checking extends Account {
	
	//List specific properties to a Checking account
	private long debitCardNumber;
	private int debitCardPIN;
	
	//Constructor to initialize Checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit, 2);
		setDebitCard();
		setRate();
	//	compound();
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() - 0.25;
	}

	//Methods for specific Checking account properties
	private void setDebitCard() {
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features:" + 
		"\n Debit Card Number: " + debitCardNumber + 
		"\n Debit Card PIN: " + debitCardPIN);
	}

}
