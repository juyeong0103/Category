package exam0613.week12;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;





public class ThreadPool2 {

	int CHUNK_SIZE = 10240;
	int N_CHUNKS = 8;
	int N = CHUNK_SIZE * N_CHUNKS;
	int[] arr = new int[N];
	private Future<Integer> future;

	class Task implements Callable<Integer> {
		int chunk_number;

		public Task(int chunk) {
			this.chunk_number = chunk;

		}

		@Override
		public Integer call() throws Exception {
			System.out.println(Thread.currentThread().getName());
			int sum = Arrays.stream(arr, chunk_number*CHUNK_SIZE,
					(chunk_number+1) * CHUNK_SIZE).sum();
			return Integer.valueOf(sum);

		}
	}

	private void process() throws InterruptedException, ExecutionException {

		Arrays.fill(arr, 1);

		List<Callable<Integer>> callableTasks = new ArrayList<>();
		for (int j = 0; j < N_CHUNKS; j++) {
			callableTasks.add(new Task(j));
		}

		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Integer>> futures = es.invokeAll(callableTasks);

		int sum = 0;
		for (Future<Integer> future : futures)
		sum += future.get();
		System.out.println(sum);
		es.shutdown();
	}


	public static void main(String[] args)
			throws InterruptedException, ExecutionException {

		long start = System.nanoTime();
		ThreadPool2 p = new ThreadPool2();
		p.process();
		long stop = System.nanoTime();
		System.out.println("계산 시간 = " + (stop - start));
		start = System.nanoTime();
		System.out.println(Arrays.stream(p.arr).parallel().sum());
		stop = System.nanoTime();
		System.out.println("계산 시간 = " + (stop - start));

	}

}
