package com.fdmgroup;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class text {
    public static void main(String[] args) {
                //printTrace();
        int result =0;
        int x = 0;
        switch (x){
            case 3:
                result+=3;
            case 2:
                result *=2;
            case 1:
                result += 1;
            default:
                result =0;
        }
        System.out.println("result " + result);

        int num1 = 10;
        int num2 = 5;
        swap(num1,num2);
        System.out.println("Num1 is equal to " + num1);
        System.out.println("Num2 is equal to " + num2);
    }

    public static void printTrace(){
        String name = null;
        try{
            System.out.println("Inside try, ");
            if(name.length() == 0){
                System.out.println("Name empty");
            }

        }catch (NullPointerException e){
            System.out.println("Inside catch");
        }finally {
            System.out.println("Inside finally");
        }
    }

    public static void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2=temp;
    }
}
