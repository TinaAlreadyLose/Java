package Taxi;
public final class PickCar extends Car {
	double cargoCapacity;
	double pessengerNumber;

	public double getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(double cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public double getPessengerNumber() {
		return pessengerNumber;
	}

	public void setPessengerNumber(double pessengerNumber) {
		this.pessengerNumber = pessengerNumber;
	}
	public PickCar() {
		super();
	}
	public PickCar(String name,String Type,float money,double cargoCapacity,double pessengerNumber) {
		super(name,Type,money);
		this.pessengerNumber=pessengerNumber;
		this.cargoCapacity=cargoCapacity;
	}
	public String toString() {
		return super.toString()+",cargoCapacity:"+this.cargoCapacity+",pessengerNumber:"+this.pessengerNumber;
	}
	public void showCar() {
		System.out.println(toString());
	}
}
