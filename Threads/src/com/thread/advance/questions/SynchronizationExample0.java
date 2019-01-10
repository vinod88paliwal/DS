package com.thread.advance.questions;
//Yes both method will be executed in parallel as only method is synchronized so other non-synchronized method locking is not required.
public class SynchronizationExample0 {

    private void h1()
    {
        System.out.println("Thread :" + Thread.currentThread().getName() + " h1() Inside");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread :" + Thread.currentThread().getName() + " h1() Leaving");
    }

    private synchronized void h2() {

        System.out.println("Thread :" + Thread.currentThread().getName() + " h2() Inside");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread :" + Thread.currentThread().getName() + " h2() Leaving");
    }

    public static void main(String ar[]) {

        SynchronizationExample0 obj = new SynchronizationExample0();

        new Thread(new Runnable() {
            @Override
            public void run() {

                obj.h1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.h2();
            }
        }).start();

        System.out.println("Done!!!");
    }
}