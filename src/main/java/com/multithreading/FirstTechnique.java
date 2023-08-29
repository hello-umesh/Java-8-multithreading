package com.multithreading;

import java.util.concurrent.TimeUnit;

public class FirstTechnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new FirstTask()).start();
		Thread t = new Thread(new FirstTask());
		t.start();
	}

}

class FirstTask implements Runnable {

	private static int count = 0;
	private int id;
	
	public FirstTask() {
		this.id = ++count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=10; i>0;i--) {
			System.out.println("Tick Tick TOO <" + id + "> ==> " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
