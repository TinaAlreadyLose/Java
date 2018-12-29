package test_1;

public class array {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i]=i;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
