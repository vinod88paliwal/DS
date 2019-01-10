package com.thread.joinmethod;
/*
Question : When join method is invoked, does thread release its resources and goes in waiting state or it keep resources and goes in waiting state?
If you look at source code of join() method, It internally invokes wait() method and wait() method release all the resources before going to WAITING state.
?

public final synchronized void join(){
    ...
    while (isAlive()) {
        wait(0);
    }
    ...
}
So, YES. join() method release resources and goes to waiting state.
 */

public class JoinThreadDemo extends Thread{

    static JoinThreadDemo thread1;

    public void run(){
        try{
            synchronized(thread1){
                System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+" completed");
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] ar) throws Exception{
        thread1 = new JoinThreadDemo();
        thread1.setName("thread1");
        thread1.start();

        synchronized(thread1){
            System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1..");
            Thread.sleep(1000);
            thread1.join();
            System.out.println(Thread.currentThread().getName()+" completed");
        }
    }
}

/*
If you see the code, "main" thread took a lock on Thread "thread1" and waits for thread1 to complete its task by calling thread1.join().
Thread "thread1", require a lock on "thread1" for executing its task.
If main thread doesn't release lock by calling thread1.join() then Thread "thread1" will not able to progress and goes in deadlock state.
 */