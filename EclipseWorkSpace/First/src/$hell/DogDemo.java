package $hell;

import java.util.Scanner;

public class DogDemo {
    public static  void  main(String[] args){
        Scanner input=new Scanner(System.in);
        DogAchieve demo = new DogAchieve();
        System.out.println("请从1、2、3中任意选择一个数");
        int size;
        do {
            size =  input.nextInt();
            demo.setSize(size);
            demo.Choosen();
        }while(size!=0);
        System.out.println("程序正常退出");
    }
}
