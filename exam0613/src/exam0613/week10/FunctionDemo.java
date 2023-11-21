package exam0613.week10;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<Integer, Double> half = a -> a / 2.0;
		Function<Integer, Double> threeHalves = half.andThen(a -> 3 * a);
		System.out.println(threeHalves.apply(3));

		Function<Integer, Double> halfOfSquare = half.compose(x -> x*x);
		System.out.println(halfOfSquare.apply(4));

		Function<Integer, Double> f1 = a -> a / 2.0;
		Function<Integer, Number> f3;

		Function<Double, Number> f21 = a -> a.intValue();
		f3 = f1.andThen(f21);
		System.out.println(f3.apply(5));

		Function<Double, Integer> f22 = a -> a.intValue();
		f3 = f1.andThen(f22);
		System.out.println(f3.apply(5));

		Function<Number, Number> f23 = a -> a;
		f3 = f1.andThen(f23);
		System.out.println(f3.apply(5));

		Function<Number, Double> f24 = a -> a.doubleValue();
		f3 = f1.andThen(f24);
		System.out.println(f3.apply(5));



	}

}
