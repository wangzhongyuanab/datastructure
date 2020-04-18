package com.interview.codeandtest;

public class InterruptTest {
	
	static class MyThread extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("count="+i);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			MyThread t1 = new MyThread();
			t1.start();
			Thread.sleep(100);
			Thread.currentThread().interrupt();
			System.out.println("线程是否中断："+t1.interrupted());
			System.out.println("线程是否中断："+t1.interrupted());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}