package $hell;

public class DogAchieve {
    private int size;
    public DogAchieve(){
        this.size=1;
    }
    public DogAchieve(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public  void Choosen(){
        switch (this.size){
            case 1: {
                Dog demo=new FirstDog();
                demo.bark();
            }
                break;
            case 2: {
                Dog demo=new SecondDog();
                demo.bark();
            }
                break;
            case 3:{
                Dog demo=new ThirdDog();
                demo.bark();
                break;
            default: System.out.println("选择错误.请选择0-3之内的数");

        }
    }
}
