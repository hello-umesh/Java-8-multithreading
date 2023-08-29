package com.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableInvokeAll {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService exservice = Executors.newFixedThreadPool(3);
		List<CallableTask> list = List.of(new CallableTask("Thread1"), 
				new CallableTask("Thread2"), new CallableTask("Thread3"));
		
		List<Future<String>> fut = exservice.invokeAll(list);
		
		for(Future<String> ft : fut) {
			System.out.println(ft.get());
		}
		
		exservice.shutdown();
	}

}
