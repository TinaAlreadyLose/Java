package test_3;

public class Person {
    private String name;
    private int age;
    private String sex;
    private boolean married;

    Person(String name, int age, String sex, boolean married) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.married = married;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean iSmarried() {
        return married;
    }

    public void setmarried(boolean married) {
        this.married = married;
    }

    public void marry(Person p) {
        if(!p.getSex().equalsIgnoreCase(this.sex)) {
            if (p.iSmarried() == false && this.married == false) {
                if (isAged(this.sex, this.age) && isAged(p.getSex(), p.getAge())) {
                    System.out.println("恭喜可以结婚");
                } else System.out.println("年龄不符合要求");
            } else System.out.println("一方已经结婚");
        }else System.out.println("禁止同性恋");
    }

    private boolean isAged(String sex ,int age) {
        if (sex.equalsIgnoreCase("男") && age >= 24) {
            return true;
        }
        if (sex.equalsIgnoreCase("女")&& age>=22)
            return true;
        return false;
    }
}
