package exam0613.week12;

import java.util.concurrent.TimeUnit;


class Timing implements Runnable {

	public void run() {
		try {
			for(int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName()
						+ ": " + i);
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException exception) {
			System.out.println("Interrupted!");
		}
	}
}
public class Thread_join {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Timing();
		Thread t1 = new Thread(r);
		t1.setName("T1");
		Thread t2 = new Thread(r);
		t2.setName("T2");
		t1.start();
		t1.join();
		t2.start();
		System.out.println("main ends.");
	}

}


