package exam0613.week11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.Set;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import static java.util.stream.Collectors.*;

public class Test {

	public static void main(String[] args) {

		List <String> season = List.of("하지", "동지", "춘분", "추분", "입동");

		int sum = season.stream()
				.filter(w -> w.charAt(w.length()-1) == '분')
				.mapToInt(w -> w.length())
				.sum();
		System.out.println(sum);
		System.out.println();

		String[] sa = new String[] {"A", "B", "C"};
		Stream<String> words = Arrays.stream(sa);
		Stream<String> words2 = Arrays.stream(sa, 1, 3);
		words.forEach(x -> System.out.println(x + ""));
		words2.forEach(x -> System.out.println(x + ""));

		Stream<BigInteger> bIntegers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		bIntegers.limit(5).forEach(x -> System.out.println(x + ""));

		Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
		stream.map(s -> s.length()).forEach(System.out::println);

		System.out.println();
		List<String> sb = List.of("AAAAA", "B", "CCC");
		sb.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(toList());
		sb.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(toList())
		.forEach(System.out::println);
		sb.stream().sorted(Comparator.comparingInt(String::length)).collect(toList())
		.forEach(System.out::println);

		IntStream numbers = IntStream.range(4, 7);
		int summ = numbers.reduce(0, (x,y) -> x+y);
		System.out.println(summ);

		List<String> words3 = List.of("1", "2", "3", "4", "5");
		String joinedString = words3.parallelStream().reduce("", (w1, w2) -> w1+w2);
		System.out.println(joinedString);

		List<String> list = new ArrayList<> (List.of("a", "ab", "abc"));
		IntStream is = list.stream().mapToInt(String::length);
		OptionalInt opt = is.max();
		int maxLength = opt.orElse(-1);
		System.out.println(maxLength);

		System.out.println();
		long count = IntStream.of(1, 3, 5, 7, 9).count();
		long sum2 = LongStream.of(1, 3, 5, 7, 9).sum();
		OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
		OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
		System.out.println(max);
		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5).average().ifPresent(System.out::println);

		List<String> sortedList = list.stream()
				.map(s -> s.substring(0, 1))
				.sorted()
				.collect(toList());
		System.out.println(sortedList);

		System.out.println();
		for (int i = 0; i < 5; i++) statefulLambda();
	}

	static void statefulLambda() {
		Set<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<Integer> list = new ArrayList<>();

		int sum = s.parallelStream().mapToInt(e -> {
			if (list.size() <= 3) {
				list.add(e);
				System.out.println(list);
				return e;
			}
			else return 0;
		}).sum();
		System.out.println("sum: " + sum);



	}

}
