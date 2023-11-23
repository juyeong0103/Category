package homework.week12;

import java.util.concurrent.TimeUnit;

class Timing implements Runnable {
	public void run() {
		try {
			for (int i = 1; i <= 100; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException exception) {
			System.out.println("인터럽트에 의해 작업 중단");
		}
	}
}

public class TwoThreads {
	public static void main(String[] args) {
		Runnable r = new Timing();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		System.out.println("main 메소드 끝.");

	}

}
