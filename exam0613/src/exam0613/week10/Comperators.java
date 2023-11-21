package exam0613.week10;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;
import java.util.SortedSet;
import java.util.TreeSet;

public class Comperators {
	public static void main(String[] args) {
		final Person 주영 = new Person("주영", "박", 20);   // 사람 객체를 원하는대로 바꿔가면서 테스트해보세요.
		final Person 희정권사님 = new Person("희정권사님", "김", 51);
		final Person 강유식목사님 = new Person("유식 목사님", "강", 53);
		

		Person[] people = new Person[] {주영, 희정권사님, 강유식목사님};

		Arrays.sort(people, Comparator.comparing(Person::getLastName));
		System.out.println(Arrays.toString(people));
		Arrays.sort(people, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));		
		Arrays.sort(people, Comparator.comparing(Person::getLastName, (s, t) -> s.length() - t.length()));
		Arrays.sort(people, Comparator.comparingInt(p -> p.getLastName().length()));
		Arrays.sort(people, comparing(Person::getLastName, nullsFirst(naturalOrder())));
		
		Comparator<Person> comp = Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge);
		SortedSet<Person> sett = new TreeSet<>(comp);
		sett.addAll(Arrays.asList(people));
		System.out.println(sett);

	}
}