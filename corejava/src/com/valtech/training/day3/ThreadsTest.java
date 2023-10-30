package com.valtech.training.day3;

public class ThreadsTest {
	public static class PrinterThread extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread()+""+i);
				
			} 
			
		}
		
		//thread as an interface..this the prefered way
		public static class PrinterThreadByInterface implements Runnable{

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread()+""+i);				
			}
			
		}
		
	}
		public static void main(String[] args) {
			
			new PrinterThread().start();
			new PrinterThread().start();
     		
			
			//for interface
			new Thread(new PrinterThreadByInterface()).start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						System.out.println(Thread.currentThread()+""+i);
					}
				}
			}).start();
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread()+""+i);
//in o/p main is the thread grp name
//more cpu time 
//multi core processor executes parelally.
			
				
			}
		


		}
	}}


