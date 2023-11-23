package exam0613.week12;

public class BankAccount2 {

	public static final double MAX_BALANCE = 100000;

	private double balance = 0.0;

	public void deposit(double amount) {
		balance += amount;
		System.out.println("입금 후 잔액: " + balance);
	}

	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("출금 후 잔액: " + balance);
	}

	public double getBalance() {
		return balance;
	}

}
