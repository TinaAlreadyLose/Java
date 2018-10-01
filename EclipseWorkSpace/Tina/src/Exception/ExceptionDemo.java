package Exception;
import java.util.Scanner;
public class ExceptionDemo {
public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入i，j的值");
		int i=input.nextInt();
		int j=input.nextInt();
		int k;
		try {
			k=i/j;
			System.out.println("k="+k);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("被零整除"+e.getMessage());
		}
		finally {
			System.out.println("程序结束");
		}
	}
}
