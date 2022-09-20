package com.fdmgroup.Threading.Exercises.ConcurrencyReadingFromFiles;

import java.io.*;

public class FileReaderThread extends Thread{

    private AverageCalculator averageCalculator;
    private String fileName;

    public FileReaderThread(AverageCalculator averageCalculator, String fileName) {
        this.averageCalculator = averageCalculator;
        this.fileName = fileName;
    }




    @Override
    public void run() {
        String currentLine;
        StringBuffer fileContents = new StringBuffer();

        try(
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while((currentLine = bufferedReader.readLine()) != null) {
                String[] numberString = currentLine.split(",");
                for(String eachNumberString : numberString) {
                    int number = Integer.parseInt(eachNumberString);
                    averageCalculator.addToTotal(number);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
