package Computer;

public class RunningDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer =new Computer();
		UDisk disk=new UDisk();
		computer.setDevice(disk);//添加一个具体的多态接口
		computer.readDate();
		computer.writeData();
		Phone phone=new Phone();
		computer.setDevice(phone);//修改添加的数据
		computer.readDate();
		computer.writeData();
		MobileHarddisk harddisk=new MobileHarddisk();
		computer.setDevice(harddisk);
		computer.readDate();
		computer.writeData();
	}

}
