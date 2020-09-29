package com.neuedu.myspringboot.common.extend;

public class Kids extends ManKind{

    private int yearsOld;

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }


    public static void main(String[] args) {

        Kids someKid = new Kids();

        someKid.setYearsOld(20);

        someKid.setSalary(1);
        someKid.setSex(1);

        someKid.manOrWoman();
        someKid.employeed();

        someKid.printAge();



    }

    public void printAge(){

        System.out.println(yearsOld);

    }

}
