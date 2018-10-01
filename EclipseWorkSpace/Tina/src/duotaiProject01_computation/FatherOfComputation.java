package duotaiProject01_computation;

public abstract class  FatherOfComputation {//模板抽象类
	int num1;
	int num2;
	public abstract int operate();
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public FatherOfComputation(){
		super();
	}
	public FatherOfComputation(int num1,int num2) {
		super();
		this.num1=num1;
		this.num2=num2;
	}
	
	
}
