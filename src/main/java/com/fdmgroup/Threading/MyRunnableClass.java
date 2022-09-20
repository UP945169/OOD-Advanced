package com.fdmgroup.Threading;

import static java.lang.Thread.sleep;

public class MyRunnableClass implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "Starting");
        for (int i = 0; i <=100 ; i++) {
            System.out.println(Thread.currentThread() + ": " + i);
            try{
                sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " Ending");
        }
    }
}
