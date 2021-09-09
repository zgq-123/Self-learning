package com.example;

public class Hello {
    public static void main(String[] args) {
       /* String s1="hello";
        String s2="hello";
        String s3=s2;*/

        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = "hello";

        System.out.println("s1:" + s1.hashCode());
        System.out.println("s2:" + s2.hashCode());
        System.out.println("s3:" + s3.hashCode());

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));

    }
}
