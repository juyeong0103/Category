package exam0613.week10;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {

		Consumer<String> consumer = s -> System.out.println(s);
		Consumer<String> consumerString = s -> System.out.println(s.toUpperCase());
		Consumer<Integer> intConsumer = i -> System.out.println(5 * i);

		consumer.accept("하이");
		consumerString.accept("High priority");
		intConsumer.accept(4);
		System.out.println("----------------");

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		Consumer<Integer> printer = n -> System.out.println(n + " ");


		numbers.forEach(printer);
		System.out.println();
		numbers.forEach(n -> System.out.print(n + " "));
		System.out.println();
		System.out.println("-----------------");
		Consumer<Integer> c1 = i -> System.out.print(5 * i + " ");
		Consumer<Integer> c2 = i -> System.out.print(5 + i + " ");

		c1.andThen(c2).accept(4);
		System.out.println();
		c2.andThen(c1).accept(5);
		System.out.println();
		c1.andThen(i -> System.out.println(3 * i)).accept(4);


	}

}
