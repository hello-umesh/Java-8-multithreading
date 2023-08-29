package com.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsApi {

	
	// Create Task definition class
	// Provide task objects to an ExecutorService
	// preferred since Java 1.5
	// Supports Fork Join since Java 1.7
	
	// many types of thread pool available
	// 1. FixedThread Pool
	// 2. CachedThreadPool
	// 3.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exService = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			exService.execute(new ExecClassA());
		}
		
		
		// recommended to shutdown the executor, otherwise it will keep on running
		exService.shutdown();
	}

}

class ExecClassA implements Runnable{
	private static int count = 0;
	private int id;
	
	public ExecClassA() {
		this.id = ++count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread starts here");
		for(int i=10; i>0;i--) {
			System.out.println("Tick Tick TOO <" + id + "> ==> " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Thread ends here");
	}
	
}
