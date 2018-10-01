package duotaiProject01_computation;

public final class Add extends FatherOfComputation{
	@Override
	public int operate() {
		return super.getNum1()+super.getNum2();
	}
	public Add() {
		super(1,1);
	}
	public Add(int num1,int num2) {
		super(num1,num2);
	}
}
