package exam0613.week11;

public class BankAccount {
	
	public BankAccount() {
		balance = 0;
	}
	
	public void deposit(double amount)
	{
		System.out.print("Depositing " + amount);
		double newBalance = balance + amount;
		System.out.println();
		System.out.println(", new balance is " + newBalance);
		balance = newBalance;
		
	}
	
	public void withdraw(double amount) {
		System.out.print("Withdrawing " + amount);
		double newBalance = balance - amount;
		System.out.println(". new balance is " + newBalance);
		balance = newBalance;
	}

	public double getBalance() {
		return balance;
	}
	
	private double balance;
	
}
