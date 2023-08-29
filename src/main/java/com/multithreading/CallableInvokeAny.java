package com.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableInvokeAny {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService exservice = Executors.newFixedThreadPool(3);
		List<CallableTask> list = List.of(new CallableTask("Thread1"), 
				new CallableTask("Thread2"), new CallableTask("Thread3"));
		
		String fut = exservice.invokeAny(list); //whichever thread completed first, 
		//it will be returned and flow gets completed
		System.out.println(fut);
		
		exservice.shutdown();
		
	}

}
