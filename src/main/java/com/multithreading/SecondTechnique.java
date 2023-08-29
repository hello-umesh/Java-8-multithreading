package com.multithreading;

import java.util.concurrent.TimeUnit;

public class SecondTechnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main method starts here");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=10; i>0;i--) {
					System.out.println("Tick Tick TOO  ==> " + i);
					try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		System.out.println("Main method ends here");
	}

}
