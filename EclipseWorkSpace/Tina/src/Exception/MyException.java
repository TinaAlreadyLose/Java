package Exception;

class MyException  extends Exception{
	public MyException() {
		
	}
	public MyException(String massage) {
		super(massage);
	}

}
 class Myclass{
	public static void  throwException() throws MyException{
		System.out.println("异常方法");
		throw new MyException("方法执行时调用");
	}
}
