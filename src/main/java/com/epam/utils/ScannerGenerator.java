package com.epam.utils;

import java.util.Scanner;

public class ScannerGenerator {
    private static Scanner scanner=null;
    public static Scanner getScanner(){
        if(scanner==null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
