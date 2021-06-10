package com.stu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ctest {
    public static void main(String[] args) throws IOException {
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=================");
        System.out.println(reader.readLine().toString());
    }
}
