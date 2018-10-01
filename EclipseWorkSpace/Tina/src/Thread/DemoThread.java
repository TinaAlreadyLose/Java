package Thread;
import java.lang.*;
class MyThread extends Thread{
	private String name;
	public MyThread(String name) {
		super();
		this.name=name;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("name"+this.name+"运行, "+i);
		}
	}
}
public class DemoThread {
/**
 * thrad常用方法
 * 1.	public Thread CurrentThread()	返回当前运行的进程
 * 2.	public String getName()			返回线程的名字
 * 3.	public void	  sleep(in m)		休眠m毫秒
 * 4.	public void   start()			启动线程	
 * 5.	public void   run()				线程的主体有jvm实现
 */
//		我们一般使用就是重写run()方法
	public static void main(String[] args) {
		MyThread demo0=new MyThread("线程A");
		MyThread demo1=new MyThread("线程B");
		demo0.start();
		demo1.start();
	}
}
