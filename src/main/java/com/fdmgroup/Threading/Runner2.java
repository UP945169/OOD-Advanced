package com.fdmgroup.Threading;

public class Runner2 {
    public static void main(String[] args) {
        System.out.println("Main method ending");
        MyRunnableClass runnable1 = new MyRunnableClass();
        MyRunnableClass runnable2 = new MyRunnableClass();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        Thread backgroundProcess = new Thread(() -> {
           while (true){
               System.out.println("Running background process");
               try {
                   Thread.sleep(30);
               } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
                   break;
               }
           }
        });

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
        backgroundProcess.start();
        try{
            thread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        backgroundProcess.interrupt();

        System.out.println("Main method ending");

    }
}
