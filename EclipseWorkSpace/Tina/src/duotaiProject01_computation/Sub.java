package duotaiProject01_computation;


public final class Sub extends FatherOfComputation {
	@Override
	public int operate() {
		return super.getNum1()-super.getNum2();
	}
	public Sub() {
		super(1,1);
	}
	public Sub(int num1,int num2) {
		super(num1,num2);
	}

}
