package com.neuedu.myspringboot.common.extend;

public class ManKind {

    int sex, salary;

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman(){

        if (sex == 1) System.out.println("man");
        else if (sex == 0) System.out.println("woman");

    }

    public void employeed(){

        if (salary == 0 ) System.out.println("no job");
        else System.out.println("job");

    }


}
