package exam0613.week12;

import java.util.concurrent.CompletableFuture;

public class SimpleDemo {

	public static void main(String[] args) throws Exception {
		
		System.out.println("시작: " + Thread.currentThread().getName());
		
		CompletableFuture.runAsync(() -> {
			System.out.println("Run" + Thread.currentThread().getName());
		});
		
		CompletableFuture<String> returnFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Supply" + Thread.currentThread().getName());
			return "Hi!";
		});
		
		System.out.println(returnFuture.get());
		System.out.println();
		
		CompletableFuture.supplyAsync(() -> {for(int i = 0; i < 1_000_000_000; i++); return "aa";})
		.thenApply(x ->  {
			System.out.println("0 " + Thread.currentThread().getName());
			return x.toUpperCase();
		})
		.thenAccept(x -> {
			System.out.println("1 " + Thread.currentThread().getName());
			System.out.println(x);
		})
		.thenAccept(x -> { 
			System.out.println("2 " + Thread.currentThread().getName());
			System.out.println();
		})
		.thenRun(() -> {
			System.out.println("3 " + Thread.currentThread().getName());
			System.out.println("End");
		});
		
		System.out.println("main은 여기에서 하고 싶은 다른 일을 할 수 있다. " + Thread.currentThread().getName());
		
		
	}

}
