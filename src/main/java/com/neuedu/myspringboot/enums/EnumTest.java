package com.neuedu.myspringboot.enums;

import java.util.Scanner;

public class EnumTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:(Small, Medium, Large, Extra_Large)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.Extra_Large)
            System.out.println("Good job--you paid attention to the _.");

    }

    enum Size{

        Small("S"), Medium("M"), Large("L"), Extra_Large("XL");

        private Size (String string) {
            this.abbreviation = string;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        private String abbreviation;
    }

}
