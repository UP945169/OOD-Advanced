package com.fdmgroup.Threading.Exercises.ConcurrencyReadingFromFiles;

public class AverageCalculator {
    private long total;
    private long count;

    public double calculateAverage(){
        return (double) total/count;
    }

    synchronized void addToTotal(int number){
        total = total + number;
        count++;
    }

    public long getTotal() {
        return total;
    }

    public long getCount() {
        return count;
    }
}
