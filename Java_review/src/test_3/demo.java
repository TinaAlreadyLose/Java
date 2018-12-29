package test_3;

public class demo {
    public static void main(String[] args) {
        Person person0 = new Person("Dan", 30, "男", false);
        Person person1 = new Person("Dan", 20, "女", false);
        Person person2 = new Person("Dan", 20, "男", true);
        Person person3 = new Person("Dan", 40, "女", true);
        Person person4 = new Person("Dan", 40, "女", false);
        person0.marry(person1);
        person0.marry(person2);
        person0.marry(person3);
        person0.marry(person4);
    }
}
