package homework.week12;

import javax.swing.JOptionPane;


public class TwoThread3 {
	
	Thread t1;
	Thread t2;
	
	void startThreads() {
		
		Runnable r = new Timing();
		
		t1 = new Thread(r);
		t2 = new Thread(r);
		t1.start();
		t2.start();
	}
	
	void interruptThread() {
		String input = JOptionPane.showInputDialog("몇 번 쓰레드를 끝낼까요? 0이나 1을 입력하세요.");
		
		if (input.equals("0"))
			t1.interrupt();
		else if (input.equals("1"))
			t2.interrupt();
	}

	public static void main(String[] args) {
		
		TwoThread3 tester = new TwoThread3();
		tester.startThreads();
		tester.interruptThread();
		tester.interruptThread();
		
	}

}
