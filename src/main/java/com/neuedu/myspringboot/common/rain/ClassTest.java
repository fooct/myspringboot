package com.neuedu.myspringboot.common.rain;

public class ClassTest {


    public static void main(String[] args) {

        Cat cat = new Cat();

        int c = cat.age(6);
        int i = 6 + 5;

        System.out.println(i);

    }


    public static class Animal{
        int i = 5;
    }

    public static class Cat extends Animal{
        public int age(Integer a){
            i += a;
            return i;
        }
    }

}
