package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<>();
		
		List<String[]> csvReader = utilities.CSV.read("E:\\new.csv");
		for (String[] accHolder : csvReader) {
			String name = accHolder[0];
			String sSN = accHolder[1];
			String accountType = accHolder[2];
			double initDeposit = Double.parseDouble(accHolder[3]);
			if (accountType.equalsIgnoreCase("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			else if (accountType.equalsIgnoreCase("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else System.out.println("ERROR TYPE ACCOUNT!!!");
		}
//		for (Account acc : accounts) {
//			acc.showInfo();
//		}
		accounts.get((int) (Math.random() * accounts.size())).withdraw(100000);;
	}
	
}
