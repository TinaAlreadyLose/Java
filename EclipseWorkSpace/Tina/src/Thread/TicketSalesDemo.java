package Thread;

import java.lang.*;
class TiketSales implements Runnable {
	private int ticket = 5;

	public void run() {
		for (int i = 0; i < 20; i++)
			this.sale();
	}

	private synchronized void sale() {
		if (this.ticket > 0) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖票:ticket=" + this.ticket--);
		}
	}
}

public class TicketSalesDemo {
	public static void main(String[] args) {

		TiketSales demo = new TiketSales();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		Thread t3 = new Thread(demo);
		t1.start();
		t2.start();
		t3.start();
	}

}
