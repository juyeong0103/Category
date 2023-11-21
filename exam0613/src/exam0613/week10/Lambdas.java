package exam0613.week10;

import java.util.concurrent.TimeUnit;

public class Lambdas {

	static Runnable r = () -> {
		for(int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + ": " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		Thread t1 = new Thread(r);
		t1.setName("Worker01");
		t1.start();

		Thread t2 = new Thread(r);
		t2.setName("Worker02");
		t2.start();
	}


}
