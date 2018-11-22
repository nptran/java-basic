package bankaccountapp;

public class Savings extends Account {

	//List specific properties to a Savings account
	private int safetyDepositBoxID;
	private int safetyDepositKey;
	
	//Constructor to initialize properties for savings account
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit, 1);
		setSafetyDepositBox();
		setRate();
	//	compound();
	}
	
	@Override
	public void setRate() {
		this.rate = getBaseRate() * 0.15;
	}
	
	
	//Specific methods to the Savings account
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositKey = (int) (Math.random() * Math.pow(10, 4));
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("Your Savings Account Features:" + 
							"\n Safety Deposit Box ID: " + safetyDepositBoxID +
							"\n Safety Deposit Box Key: " + safetyDepositKey);
	}
	
}
