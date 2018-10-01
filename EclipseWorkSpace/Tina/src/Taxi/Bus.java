//公共汽车
package Taxi;
public final class Bus extends Car {
	private double PassengerNumbe;

	public double getPassengerNumbe() {
		return PassengerNumbe;
	}

	public void setPassengerNumbe(double passengerNumbe) {
		this.PassengerNumbe = passengerNumbe;
		
	}
	public void showCar() {
		System.out.println(toString());
	}
	public Bus() {
		super();
	}
	public Bus(String name,String Type,float money,double PassengerNumbe) {
		super(name,Type,money);
		this.PassengerNumbe=PassengerNumbe;
	}
	@Override
	public String toString () {
		return super.toString()+",PassengerNumbe:"+PassengerNumbe;
	}
}
