package exam0613.week12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor_231123 {
                                                            // 예외처리 
	public static void main(String[] args) throws InterruptedException,
	ExecutionException  {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<String> future = executor.submit(() -> "Callable Result");
		System.out.println("future.get() = " + future.get());
		
	}

}
