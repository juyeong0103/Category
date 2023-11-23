package exam0613.week12;

import java.util.concurrent.TimeUnit;

public class TwoThreadsLanbda {

	public static void main(String[] args) {
		Runnable r = () -> {
			try {
				for (int i = 1; i <= 100; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
					TimeUnit.MILLISECONDS.sleep(500);
				}
			} catch (InterruptedException exception) {
				System.out.println("Interrupted!");
				
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		System.out.println("main ends.");
		
	}

}
