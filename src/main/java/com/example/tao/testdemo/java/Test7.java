package com.example.tao.testdemo.java;

import org.apache.commons.codec.binary.Hex;

import java.io.*;

public class Test7 {


    public static void main(String[] args) throws Exception {
//        FileOutputStream outputStream = new FileOutputStream("b.txt");
//        outputStream.write("a".getBytes("GBK"));
//        outputStream.write("A".getBytes("GBK"));
//        outputStream.write("A".getBytes("UTF-8"));


        FileOutputStream outputStream = new FileOutputStream("c.txt");
        outputStream.write("好的".getBytes("GBK"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("c.txt")));
        String s = reader.readLine();
        System.out.println(s);
    }
}
