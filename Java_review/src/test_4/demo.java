package test_4;

import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入一个数来计算其立方");
        double number = cin.nextDouble();
        MyClass myClass = new MyClass();
        System.out.println(myClass.area(number));
    }

}
