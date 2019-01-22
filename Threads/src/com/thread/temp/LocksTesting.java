package com.thread.temp;

import java.time.LocalDateTime;

public class LocksTesting {

	synchronized void hello()
	{
		System.out.println("hello()"+ Thread.currentThread().getName()+" "+ LocalDateTime.now());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void hello1()
	{
		System.out.println("hello1()"+ Thread.currentThread().getName()+" "+ LocalDateTime.now());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized static void hello2()
	{
		System.out.println("hello2()"+ Thread.currentThread().getName()+" "+ LocalDateTime.now());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	synchronized static void hello3()
	{
		System.out.println("hello3()"+ Thread.currentThread().getName()+" "+ LocalDateTime.now());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		LocksTesting obj = new LocksTesting();
		
		new Thread(() -> obj.hello()).start();
		new Thread(() -> obj.hello1()).start();
		new Thread(() -> obj.hello2()).start();
		new Thread(() -> obj.hello3()).start();
	}

}
