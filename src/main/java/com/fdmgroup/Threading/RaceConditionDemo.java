package com.fdmgroup.Threading;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(()->{
            for (int i = 0; i < 900000; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            decrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
