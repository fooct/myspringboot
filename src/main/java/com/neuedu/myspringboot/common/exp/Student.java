package com.neuedu.myspringboot.common.exp;

public class Student {
    private String name;
    private int age;
    private String class1;
    private String xingqu;

    public void xueshengxinxi(){

        name = "小明";
        age = 19;
        class1 = "二班";
        xingqu = "运动";

        System.out.println("名字：" + name );
        System.out.println("年龄:" + age);
        System.out.println("参加的课程：" + class1);
        System.out.println("兴趣：" + xingqu);

    }



}
