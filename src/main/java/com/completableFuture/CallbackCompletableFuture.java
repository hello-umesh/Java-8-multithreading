package com.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class CallbackCompletableFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
			delay(2);
			return "CallableCompletable Future example";
		}).thenApply(s -> {
			return ", Good morning!" + s;
		}).thenRun(() -> {
			System.out.println(" Completed. ");
		});

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
