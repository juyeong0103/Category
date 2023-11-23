package exam0613.week12;

import exam0613.week11.BankAccount;

public class DepositeRunnable implements Runnable {

	private static final int DELAY = 1;
	private BankAccount2 account;
	private double amount;
	private int count;

	public DepositeRunnable(BankAccount2 anAccount, double anAmount, int c) {
		account = anAccount;
		amount = anAmount;
		count = c;

	}

	public void run() {
		try {
			for (int i = 1; i <= count; i++) {
				account.deposit(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {

		}

	}

}
