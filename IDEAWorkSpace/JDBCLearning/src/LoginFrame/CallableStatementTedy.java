package LoginFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CallableStatementTedy {
    private String driver;
    private  String url;
    private String username;
    private  String password;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

   public CallableStatementTedy() {
       this.driver = "com.mysql.cj.jdbc.Driver";
       this.url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT";
       this.username = "root";
       this.password = "123456";
    }
//  数据库添加  ALTER TABLE student_table  ADD PRIMARY KEY (name)
    public void Query(String sql)  throws Exception {

        Class.forName(driver);
        connection= DriverManager.getConnection(this.url,this.username,this.password);
        preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        resultSet=preparedStatement.executeQuery();
        resultSet.last();
        int rowCount=resultSet.getRow();
        for(int i=rowCount;i>0;i--){
            resultSet.absolute(i);
            System.out.println(resultSet.getString(1)+"\t"
            +resultSet.getString(2)+"\t"+"学生名"+i);
            resultSet.updateString(2,"学生名"+);
            resultSet.updateRow();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }

}
