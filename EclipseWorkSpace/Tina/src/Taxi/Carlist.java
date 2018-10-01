package Taxi;
import java.util.*;
public class Carlist {
	private Car[] cars;

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}
	public Carlist(Car[] cars) {
		super();
		this.cars=cars;
	}
	public Carlist() {
		super();
		cars=new Car[] {
				new Sedan("奥迪A4","小轿车",500,4),
				new Sedan("马自达","小轿车",400,4),
				new PickCar("皮卡雪","皮卡",450,4,2),
				new Bus("金龙","大公交",600,30),
				new Trunk("东方","卡车",500,6.5),
				new Bus("依维柯", "大公交", 300, 20)
		};
	}
	public String toString() {
		return "汽车清单:\n"+Arrays.toString(cars);
	}
}
