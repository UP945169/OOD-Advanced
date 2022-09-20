package com.fdmgroup.Threading.Exercises;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " is running");

    }
}
