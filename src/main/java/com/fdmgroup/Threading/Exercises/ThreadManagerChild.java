package com.fdmgroup.Threading.Exercises;

public class ThreadManagerChild extends ThreadManager{

    @Override
    void createThreads(int number) {
        for (int i = 0; i <= number; i++) {
            Thread thread = new Thread(() -> {
                    System.out.println("Thread is running");
            });
            thread.setName("Thread " + number);
            super.threads.add(thread);
        }
    }
}
