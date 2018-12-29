package test_2;

public class Fish extends Animal {
    Fish(String name) {
        super(name, 0);
    }
    @Override
    public void move() {
//        super.move();继承父类的方法
        System.out.println(getName()+"Swimming");
    }
}
