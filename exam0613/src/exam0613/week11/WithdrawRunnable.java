package exam0613.week11;

public class WithdrawRunnable implements Runnable  {

	public WithdrawRunnable(BankAccount anAccount, double anAmount, int aCount) {

		account = anAccount;
		amount = anAmount;
		count = aCount;
	}





	public void run() {
		try {
			for (int i = 1; i <= count; i++) {
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException exception) {}

	}

	private static final int DELAY = 1;
	private BankAccount account;
	private double amount;
	private int count;


}
