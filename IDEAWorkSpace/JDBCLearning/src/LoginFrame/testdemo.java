package LoginFrame;

public class testdemo
{
    public static void main(String[] args) throws  Exception{
        CallableStatementTedy demo =new CallableStatementTedy();
        demo.Query("select * from student_table");
    }
}
