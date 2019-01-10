package com.thread.threadpool;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		ScheduledFuture scheduledFuture =
		    scheduledExecutorService.schedule(new Callable() {
		        public Object call() throws Exception {
		            System.out.println("Executed!");
		            return "Called!";
		        }
		        
		    },
		    5,
		    TimeUnit.SECONDS);


		
		    //OR
		
		ScheduledFuture scheduledFuture1 =
			    scheduledExecutorService.schedule(() -> { 
			            System.out.println("Executed!");
			            return "Called!";
			    }, 5, TimeUnit.SECONDS);


		try {
			System.out.println("Task1 : "+scheduledFuture.get());
			System.out.println("Task2 : "+scheduledFuture1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
