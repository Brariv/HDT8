package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TxtReader txtReader = new TxtReader();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to the file: ");
        String path = scanner.nextLine();
        ArrayList<ArrayList<String>> data = txtReader.readTxTFile(path);
        System.out.println(data);


        scanner.close();
    }
}