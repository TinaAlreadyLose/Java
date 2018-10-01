package Computer;
public interface IMobleDevice{
	default public void write() {
		System.out.println("kaka");
	}
	default public void read() {
		System.out.println("kaka");
	}
}