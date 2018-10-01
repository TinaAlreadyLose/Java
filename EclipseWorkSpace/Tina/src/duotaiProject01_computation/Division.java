package duotaiProject01_computation;

public final class Division extends FatherOfComputation {
	@Override
	public int operate() {
		return super.getNum1()/super.getNum2();
	}
	public Division() {
		super(1,1);
	}
	public Division(int num1,int num2) {
		super(num1,num2);
	}

}
