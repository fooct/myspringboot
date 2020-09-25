package com.neuedu.myspringboot.exp;

import java.util.Arrays;

public class Teacher {

    private String name;
    private int age;
    private String[] class1;
    private int jiaoling;

    public void show(){

        name = "张三";
        age = 50;
        String[] class1 = new String[]{"语文", "数学", "英语"};
        jiaoling = 20;

        System.out.println("教师姓名:" + name);
        System.out.println("年龄：" + age);
        System.out.println(Arrays.toString(class1));
        System.out.println("教龄" + jiaoling);

    }

}
