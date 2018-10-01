//卡车
package Taxi;
public final class Trunk extends Car{
	private double corgoCapacity;

	public double getCorgoCapacity() {
		return corgoCapacity;
	}

	public void setCorgoCapacity(float corgoCapacity) {
		this.corgoCapacity = corgoCapacity;
	}
	public void showCar() {
		System.out.println(toString());
	}
	public String toString() {
		return super.toString()+",corgoCapacity:"+corgoCapacity;
	}
	public Trunk() {
		super();
	}
	public Trunk(String name,String Type,float money,double corgoCapacity) {
		super(name,Type,money);
		this.corgoCapacity=corgoCapacity;
	}
}
