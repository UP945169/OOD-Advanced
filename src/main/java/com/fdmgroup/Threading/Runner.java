package com.fdmgroup.Threading;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Main method starting");
        MyThreadClass thread1 = new MyThreadClass();
        MyThreadClass thread2 =  new MyThreadClass();

        Thread thread3 = new Thread(() -> {
            System.out.println("Running thread 3");
        });

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Main method ending");
    }
}
