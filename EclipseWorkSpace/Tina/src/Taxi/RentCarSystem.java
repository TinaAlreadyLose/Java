package Taxi;

import java.util.*;

public class RentCarSystem {
	private Carlist list;
	private int[] choices;
	Scanner input = new Scanner(System.in);

	public RentCarSystem() {
		list = new Carlist();
		choices = new int[list.getCars().length];
	}

	public RentCarSystem(Carlist list, int[] choices) {
		super();
		this.list = list;
		this.choices = choices;
	}
	void run() {
		welcome();
		choiceCar();
		bye();
	}

	public void welcome() {
		System.out.println("*************");
		System.out.println("欢迎使用租车系统");
		System.out.println("*************");
	}

	public void bye() {
		System.out.println("*************");
		System.out.println("欢迎再次光临");
		System.out.println("*************");
	}

	public void choiceCar() {
		char car;
		do {
			System.out.println("1、租车，0、退出");
			car = input.nextLine().charAt(0);
			showCars();
			if (car == '1')
				rentOneCar();
			else if (car == '0')
				break;
			else
				System.out.println("错误，请重新输入");
		} while (true);
		showRentCar();
	}

	public void rentOneCar() {
		System.out.println("请输入你要租车的序号");
		int carNum=Integer.parseInt(input.nextLine());
		if(carNum>0&&carNum<choices.length&&choices[carNum]==0) {
			System.out.println("请选择你要租车的时间");
			String days=input.nextLine();
			choices[carNum]=Integer.parseInt(days);
			System.out.println("已成功租到车");
		}
		else System.out.println("你输入的选择无效");
	}
	public void showRentCar() {
		System.out.println("******************");
		System.out.println("您租用了一下这些车辆");
		double money=0;
		int count=0;
		Car[] cars=list.getCars();
		for(int i=0;i<choices.length;i++) {
			if(choices[i]>0) {
				System.out.println(list.getCars()[i].toString()+"租车时间"+choices[i]+"天");
				count++;
				System.out.println(cars[i].getMoney());
				money+=(choices[i]*cars[i].getMoney());
			}
		}
		if(count>0) {
		System.out.printf("您一共助理 %d辆车，共计金额 %.2f员\n",count,money);
			System.out.println("car"+count+"money"+money);
		}
		else System.out.println("您没有租车");
	}
	public void showCars() {
		Car[] cars = list.getCars();
		System.out.println("******************");
		System.out.println("系统提供一下车牌供你选择");
		for (int i = 0; i < choices.length; i++) {
			if(choices[i]==0)
			System.out.println("序号：" + i + "," + cars[i]);
		}
	}
}
