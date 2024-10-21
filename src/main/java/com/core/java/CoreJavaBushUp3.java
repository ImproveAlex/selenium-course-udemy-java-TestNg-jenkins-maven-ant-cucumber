package com.core.java;

import java.util.Arrays;

public class CoreJavaBushUp3 {
    public static void main(String[] args) {
        String s = "Alejandro Enrique Gonzalez";
        String s1 = "Pedro";
        String s2 = new String("Hello");

        String[] spplitedString = s.split("Enrique");
        for(String myString : spplitedString){
            myString = myString.trim();
            for(int i = myString.length()-1;i>=0;i--) {
                System.out.println(myString.charAt(i));
            }
        }
    }
}
