package exam0613.week12;

import exam0613.week11.BankAccount;

public class WithdrawRunnable implements Runnable {

	private static final int DELAY = 1;
	private BankAccount2 account;
	private double amount;
	private int count;

	public WithdrawRunnable(BankAccount2 account2, double anAmount, int c) {
		account = account2;
		amount = anAmount;
		this.count = c;

	}


	public void run() {
		try {
			for (int i = 1; i <= count; i++) {
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {

		}

	}

}
