package com.neuedu.myspringboot.common.constructor;

class Preson {

    private int age;
    private String name;
    private String school;
    private String major;


    public Preson(String n, int a) {

        this.name = n;
        this.age = a;

    }

    public Preson (String n, int a, String s) {

        this.name = n;
        this.age = a;
        this.school = s;

    }

    public Preson (String n, int a, String s, String m) {

        this.name = n;
        this.age = a;
        this.school = s;
        this.major = m;

    }


    public void show() {

        System.out.println(name + "\n" + age + "\n" + school + "\n" + major);
        System.out.println("*******************************");

    }

}
