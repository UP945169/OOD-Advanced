package com.fdmgroup.Threading;

public class MyThreadClass extends Thread{
    public void run(){
        System.out.println(getName() + "Starting");
        for (int i = 0; i <=100 ; i++) {
            System.out.println(getName() + ": " + i);
            try{
                sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(getName() + " Ending");
        }
    }
}
