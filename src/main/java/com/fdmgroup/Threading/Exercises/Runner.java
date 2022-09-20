package com.fdmgroup.Threading.Exercises;

public class Runner{
    public static void main(String[] args) {
        /*ThreadManager threadManager = new ThreadManager();
        threadManager.createThreads(10);
        threadManager.runThreads();*/
        ThreadManagerChild threadManagerChild = new ThreadManagerChild();
        threadManagerChild.createThreads(10);
        threadManagerChild.runThreads();
    }
}
