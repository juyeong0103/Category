package exam0613.week10;

import java.util.List;
import java.util.function.Consumer;

class PrintConsumer implements Consumer<Integer> {
	public void accept(Integer i) {
		System.out.print(i);

	}
}




public class ComsumerDemo {

	public static void main(String[] args) {

		List<Integer> list = List.of(1,2,3);
		list.forEach(new PrintConsumer());
		System.out.println();
		list.forEach(x -> System.out.print(x));
		System.out.println();
		list.forEach(System.out::print);
		System.out.println();

	}

}
