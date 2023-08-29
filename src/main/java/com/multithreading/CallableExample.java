package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Callable uses call() method
// callable call() methods returns an Object/object

public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService exService = Executors.newFixedThreadPool(1);
		Future<String> strFuture = exService.submit(new CallableTask("Callable Thread"));
		
		String msg = strFuture.get(); 
		// get() will wait for the task to be completed ,then would allow the flow to went ahead
		System.out.println(msg);
		exService.shutdown();
		System.out.println("Main completed");
	}

}


class CallableTask implements Callable<String> {

	private String name;
	CallableTask(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int i =10; i>0; i--) {
			TimeUnit.MICROSECONDS.sleep(250);
			System.out.println("Thread: " + name + "==> " +i);
		}
		return "This is thread: " + name;
	}
	
}
