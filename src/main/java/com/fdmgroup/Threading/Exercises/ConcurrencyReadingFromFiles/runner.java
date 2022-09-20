package com.fdmgroup.Threading.Exercises.ConcurrencyReadingFromFiles;

import static com.fdmgroup.Threading.Exercises.ConcurrencyReadingFromFiles.FileAdderClass.createNumberFile;

public class runner {
    public static void main(String[] args) {
        System.out.println("Application started");

        AverageCalculator averageCalculator = new AverageCalculator();

        String fileName = "C:\\temp\\records1.txt";
        String fileName2 = "C:\\temp\\records2.txt";

        FileReaderThread fileReaderThread = new FileReaderThread(averageCalculator,fileName);
        FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalculator,fileName2);
        fileReaderThread.run();
        fileReaderThread2.run();
        try {
            fileReaderThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(averageCalculator.calculateAverage());
        System.out.println(averageCalculator.getTotal());
        System.out.println(averageCalculator.getCount());
        System.out.println("Application finished");

        Thread currentTotalThread = new Thread(() -> {
            while (true){
                System.out.println("Average: " + averageCalculator.calculateAverage() +
                        "Total: " + averageCalculator.getTotal() + "Count: " + averageCalculator.getCount());
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    break;
                }
            }
        });
        fileReaderThread.start();
        fileReaderThread2.start();

        currentTotalThread.start();

        try {
            fileReaderThread.join();
            fileReaderThread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(averageCalculator.calculateAverage());
        System.out.println(averageCalculator.getTotal());
        System.out.println(averageCalculator.getCount());

        currentTotalThread.interrupt();

    }
}
