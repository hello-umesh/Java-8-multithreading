package com.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTask {
	
	
	// Future class represents a future result of an asynchronous computation - 
	// a result that will eventually appear in the Future after the processing is complete.
	
	// CompletableFyure implements Future and CompletionStage interfaces.
	// provides huge set of convenience methods for creating, chaining and combining multiple Futures
	// provides extensive exception handling
	
	// it has two methods 1. runAsync() 2. supplyAsync()
	// 1. runAsync() takes Runnable object and return CompletebaleFuture<void>
	// 2. supplyAsync() takes Supplier<T> and returns CompletableFuture<T>
	
	// CompletebaleFuture executes this tasks in a thread obtained from the global ForkJoinPool.commonPool()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            delay(1);
            System.out.println("I am in Runnable - "+ Thread.currentThread().getName());
        };

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, executorService);
        // if we don't pass executorService in above method, ForkJoinPool.commonPool would be used.
        
        System.out.println("I am in main - "+ Thread.currentThread().getName());

        completableFuture.join();
	}
	
	public static void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

