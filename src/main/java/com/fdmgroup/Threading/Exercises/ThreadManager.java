package com.fdmgroup.Threading.Exercises;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    protected List<Thread> threads = new ArrayList<>();

    void createThreads(int number){
        for (int i = 0; i <= number; i++) {
            MyRunnable myRunnableThread1 = new MyRunnable();
            Thread thread = new Thread(myRunnableThread1);
            thread.setName("Thread " + i);
            threads.add(thread);
        }
    }

    void runThreads() {
        for (int i = 0; i <= threads.size()-1; i++) {
            threads.get(i).start();
        }
    }
}
