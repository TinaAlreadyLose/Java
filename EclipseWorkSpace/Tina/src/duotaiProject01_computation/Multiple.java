package duotaiProject01_computation;

public final class Multiple extends FatherOfComputation {
	@Override
	public int operate() {
		return super.getNum1()*super.getNum2();
	}
	public Multiple() {
		super(1,1);
	}
	public Multiple(int num1,int num2) {
		super(num1,num2);
	}

}
