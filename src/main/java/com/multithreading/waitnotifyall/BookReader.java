package com.multithreading.waitnotifyall;

public class BookReader implements Runnable {

	Book book;

	public BookReader(Book book) {
		super();
		this.book = book;
	}

	@Override
	public void run() {
		synchronized (book) {
			System.out.println(
					Thread.currentThread().getName() + " is waiting for the book to be completed: " + book.getTitle());
			try {
				book.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": Book has been completed now!! you can read it");
		}
	}

}

class Book {

	String title;
	boolean isCompleted;

	public Book(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}
