package Computer;

public class Phone implements IMobleDevice {
	public void write() {
		System.out.println("把笔记本数据写入手机");
	}
	public void read() {
		System.out.println("从手机读取数据到笔记本");
	}

}
