package homework.week12;

public class NumberPrinterRunner1 {

	public static void main(String[] args) {

		NumberPrinter r1 = new NumberPrinter(0);
		Thread t1 = new Thread(r1);
		t1.setName("t1");

		NumberPrinter r2 = new NumberPrinter(0);
		Thread t2 = new Thread(r2);
		t2.setName("t2");

		t1.start();
		t2.start();
	}

}
