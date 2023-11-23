package exam0613.week12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadSafe {

	static class Counter {
		int count = 0;
		void up() {
			count++;
		}
		int getCount() {
			return count;
		}
	}

	static class SafeCounter {
		int count = 0;
		synchronized void up() {
			count++;
		}
		int getCount() {
			return count;
		}
	}


	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();
		IntStream.range(0, 100).parallel().forEach(i -> c.up());
		System.out.printf("일반 Counter: %d\n", c.getCount());

		SafeCounter sc = new SafeCounter();

		IntStream.range(0, 100).parallel().forEach(i -> sc.up());
		System.out.printf("Safe Counter: %d\n", sc.getCount());

		AtomicInteger a = new AtomicInteger();
		IntStream.range(0, 100).parallel().forEach(i -> a.incrementAndGet());
		System.out.printf("AtomicInteger: %d\n", a.get());
		System.out.println();

		Counter c2 = new Counter();
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(() -> {
			for (int i = 0; i < 100_000; i++)
				c2.up();
		});
		es.execute(() -> {
			for (int i = 0; i < 100_000; i++) 
				c2.up();

		});

		es.shutdown();

		es.awaitTermination(10, TimeUnit.SECONDS);
		System.out.printf("일반 Counter: %d\n", c2.getCount());

		AtomicInteger a2 = new AtomicInteger();
		ExecutorService es2 = Executors.newCachedThreadPool();
		es2.execute(() -> {
			for (int i = 0; i < 100_000; i++)
				a2.incrementAndGet();
		});
		es2.execute(() -> {
			for (int i = 0; i < 100_000; i++)
				a2.incrementAndGet();

		});
		es2.shutdown();
		es2.awaitTermination(10, TimeUnit.SECONDS);
		System.out.printf("AtomicInteger: %d\n", a2.get());

	}

}
