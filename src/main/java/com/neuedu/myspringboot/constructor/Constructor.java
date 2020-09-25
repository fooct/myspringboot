package com.neuedu.myspringboot.constructor;

public class Constructor {

    public static void main(String[] args) {

        Preson preson = new Preson("张三", 18);
        preson.show();

        Preson preson1 = new Preson("张三", 18,"东软信息学院");
        preson1.show();

        Preson preson2 = new Preson("张三", 18,"东软信息学院","软件工程");
        preson2.show();

    }

}

