package Computer;

public class Computer {
	IMobleDevice device;

	public Computer() {
		super();
	}

	public Computer(IMobleDevice device) {
		super();
		this.device = device;
	}

	public IMobleDevice getDevice() {
		return device;
	}

	public void writeData() {
		device.write();
	}

	public void readDate() {
		device.read();
	}

	public void setDevice(IMobleDevice device) {
		this.device = device;
	}

}
