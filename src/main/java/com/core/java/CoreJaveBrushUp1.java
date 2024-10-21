package com.core.java;

import java.sql.Array;
import java.util.Arrays;

public class CoreJaveBrushUp1 {
    public static void main(String[] args) {
        int myNum = 5;
        String website = "Rahul Shetty Academy";
        char letter = 'A';
        double dec = 2.343;
        boolean married = true;
        System.out.printf("Website: %s, initial: %c, decimal: %f, Married? %b. Favorite number: %d \n", website, letter, dec, married, myNum);

        int[] array = new int[10]; // Creates an array of size 5
        Arrays.setAll(array, i -> i*i*i+10);
        System.out.println(Arrays.toString(array)); // Print the contents of the array
        String [] brosers = {"Chrome", "Firefox","Edge", "IE"};
        for (String browser : brosers){
            System.out.println(browser);
        }
    }
}
