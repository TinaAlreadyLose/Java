package duotaiProject01_computation;
import java.util.*;
public class OperationDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner InPut=new Scanner(System.in); 
		int a;	
		int b;
		int choosen;
		do {
			System.out.println("请输入第一个数");
			 a=InPut.nextInt();
			System.out.println("请输入第二个数");
			 b=InPut.nextInt();
			System.out.println("亲选择");
			System.out.println("1:加");
			System.out.println("2:减");
			System.out.println("3:乘");
			System.out.println("4：除");
			System.out.println("0：退出");
			choosen=InPut.nextInt();
			FatherOfComputation demo;
			switch(choosen) {
			case 1:
				demo =new Add(a,b);
				System.out.println(demo.operate());
				break;
			case 2:
				demo =new Sub(a,b);
				System.out.println(demo.operate());
				break;
			case 3:
				demo =new Multiple(a,b);
				System.out.println(demo.operate());
				break;
			case 4:
				demo =new Division(a,b);
				System.out.println(demo.operate());
				break;
			default :System.out.println("错误，请重新输入");
			}
		}while(choosen!=0);
	}

}
