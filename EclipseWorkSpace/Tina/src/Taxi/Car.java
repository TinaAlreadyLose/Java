package Taxi;
public abstract class Car {
	String name;
	String Type;
	float money;
	public abstract void showCar();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Car() {
		super();
	}
	public Car(String name,String Type ,float money){
		this.name=name;
		this.Type=Type;
		this.money=money;
	}
	public String toString() {
		return ("name:"+name+","+"type:"+Type+","+"money"+money);
	}
}
