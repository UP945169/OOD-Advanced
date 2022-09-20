package com.fdmgroup.Threading.Exercises.ConcurrencyReadingFromFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAdderClass {
    public static void createNumberFile(String fileName, int numberOfLines, int maxNumber) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (int lineNumber = 1; lineNumber <= numberOfLines; lineNumber++) {
                int numberOfRecords = (int) (Math.random() * 90);
                numberOfRecords += 10;
                String line = "";

                for (int record = 1; record <= numberOfRecords; record++) {
                    int data = (int) (Math.random() * maxNumber);
                    line = line + data + ",";
                }

                line = line.substring(0, line.length() - 1);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}