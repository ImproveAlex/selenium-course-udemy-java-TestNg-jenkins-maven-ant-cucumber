package com.core.java;

import java.util.ArrayList;
import java.util.Arrays;

public class CoreJaveBrushUp2 {
    public static void main(String[] args) {
        int[] arr2= {1,2,3,4,5,6,7,8,9,10,112};
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] % 2 == 0){
                System.out.println(arr2[i]);
            }
            else {
                System.out.println(arr2[i] + " Is not multiple of 2");
            }
        }
        ArrayList<String> myList = new ArrayList<String>();
        myList.addAll(Arrays.asList("Alejandro", "Gonzalez", "Nunez", "Madrid", "Spain"));
        for (String element : myList){
            if (myList.contains("Alejandro")) {
                System.out.println(element);
            }
        }
    }
}
