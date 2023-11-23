package exam0613.week12;

import exam0613.week11.BankAccount;

public class BankAccountThreadRunner {

	public static void main(String[] args) {
		
		BankAccount2 account = new BankAccount2();
		
		final double AMOUNT = 100;
		final int REPETITIONS = 10;
		
		final int DEPOSIT_THREADS = 10;
		final int WITHDRAW_THREADS = 2;
		
		for (int i = 0; i < DEPOSIT_THREADS; i++) {
			DepositeRunnable d = new DepositeRunnable(account, AMOUNT,
					REPETITIONS);
			Thread t = new Thread(d);
			t.start();
		}
		
		for (int i = 0; i < WITHDRAW_THREADS; i++) {
			WithdrawRunnable d = new WithdrawRunnable(account, AMOUNT,
					REPETITIONS * DEPOSIT_THREADS / WITHDRAW_THREADS);
			Thread t = new Thread(d);
			t.start();
		}
		
		
			
		}
 	}


