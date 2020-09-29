package com.neuedu.myspringboot.common.rain;

public class ArrayTest {


    public static void main(String[] args) {

        ArrayTest arrayTest = new ArrayTest();
        arrayTest.arraySum();
//        调用方法

    }

    public void arrayTest(){

//        动态初始化
        int []a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

//静态初始化
        int []a1 = new int[]{1, 2, 3};


    }

    public void arraySum(){
        int[][] b = new int[][]{{3, 8, 2}, {2, 7}, {9, 0, 1, 6}};
//        初始化数组并赋值
        int sum = 0;
        for (int i = 0;i<b.length;i++) for (int j = 0;j<b[i].length;j++) sum += b[i][j];
//        累加求和
        System.out.println(sum);
    }
}
