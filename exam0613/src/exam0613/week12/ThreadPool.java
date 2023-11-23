package exam0613.week12;

import static org.junit.Assert.assertNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class ThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Runnable runnableTask = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread().getName() + ": Run");
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		};

		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(500);
			return Thread.currentThread().getName() + ": Callable";

		};

		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(runnableTask);
		System.out.println(Thread.currentThread().getName() + ": execute Runnable 후 " + LocalTime.now());

		Future<?> f = es.submit(runnableTask);
		System.out.println(Thread.currentThread().getName() + ": submit Runnable 후 " + LocalTime.now());
		assertNull(f.get());
		System.out.println();

		Future<String> future = es.submit(callableTask);
		System.out.println(Thread.currentThread().getName() + ": submit Callable 후 " + LocalTime.now());
		String result = future.get();
		System.out.println(result);

		boolean canceled = future.cancel(true);
		System.out.println(canceled);
		System.out.println();

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);

		System.out.println(Thread.currentThread().getName() + ": invokeAll 호출 전 " + LocalTime.now());
		List<Future<String>> futures = es.invokeAll(callableTasks);
		System.out.println(Thread.currentThread().getName() + ": invokeAll 호출 후 " + LocalTime.now());

		for(Future<String> ft : futures)
			System.out.println(ft.get());

		System.out.println();

		es.shutdown();




	}	
}
