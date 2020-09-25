package com.neuedu.myspringboot.rain;

public class DemoTest {
    private static boolean flag;
    private static int i;
    public static void main(String[] args) {
        String srt1 = "4";
//        String 不可以直接赋值数字
//        String str1 = "abc";
//        判断对错
        String str2 = 3.5f + "";
//        3.5f + “” 强制转换成 string 类型
//        判断 str2 对错
        System.out.println(str2);
        System.out.println(3 + 4 + "Hello!");
        System.out.println("Hello!" + 3 + 4);
        System.out.println('a' + 1 + "Hello!");
        System.out.println("Hello" + 'a' + 1);
        System.out.println(flag);
        System.out.println(i);

//        强制转换 --- 大容量转小的
        int i = 127;
        byte b = (byte) i;
        System.out.println(b);
        int c = (int) 23.99;
        System.out.println(c);

//        包装类型转换
        Double f = 23.99;
        int g = f.intValue();
        System.out.println(g);
        int z = 12;
        Double d = Double.valueOf(z);
        System.out.println(d);
/*      1、如何将字符串 String 转换成整数 int?
        A.有两个方法：
        1) int i = Integer.parseInt([String]);  or
               i = Integer.parseInt([String],[int radix]);
        2) int i = Integer.parseInt(my_str).intValue();
        注: 字符串转换成 Double, Float, Long 的方法大同小异.
        2、如何将整数 int 转换成字符串 String ?
        A. 有三种方法
        1) String s = String.valueOf(i);
        2) String s = Integer.toString(i);
        3) String s = "" + i;
        住: Double, Float, Long 转换成字符串的方法大同小异.
        */

//        String and int
        String s1 = "13";
        int t1 = Integer.parseInt(s1);
        int t2 = Integer.valueOf(s1).intValue();

        // int to String
        int tt1 = 13;
        String ss1 = String.valueOf(tt1);
        String ss2 = Integer.toString(tt1);
        String ss3 = "" + tt1;

    }
}
