package $hell;

public class ClockTest {
    public static void main(String[] args) {
        Clock time = new Clock();
        time.setTime("12345");
        System.out.println("time: "+time.getTime());
    }
}
