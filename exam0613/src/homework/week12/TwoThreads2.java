package homework.week12;

public class TwoThreads2 {

	public static void main(String[] args) throws InterruptedException {

		Runnable r = new Timing();
		Thread t = new Thread(r);
		t.start();

		Thread.sleep(5000);

		t.interrupt();

	}

}
