package Thread;

import java.lang.*;

class myRunnale implements Runnable {
	private String name;

	public myRunnale(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("name:" + this.name + ",run" + i);
	}
}

public class DemoRunnable {
	public static void main(String[] args) {

		myRunnale demo1 = new myRunnale("thread1");
		myRunnale demo2 = new myRunnale("thread2");
		Thread t1 = new Thread(demo1);
		Thread t2 = new Thread(demo2);
		t1.start();
		t2.start();

	}
}
