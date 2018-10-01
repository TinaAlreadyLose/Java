package ConnectMySql;

import java.sql.*;

public class ConnMySql {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功加载MySQL驱动");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到MySQL驱动");
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT";
        String user="root";
        String password="123456";
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            stat = conn.createStatement();
            System.out.println("成功连接到数据库了");
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        ResultSet res = null;
        try {
            res = stat.executeQuery("SELECT *from firstdemo");
            System.out.println("可以操作数据库");
            while (res.next()) {
                System.out.println(res.getInt(1)
                        + "\t" + res.getString(2)
                        + "\t" + res.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("不能操作数据库");
            e.printStackTrace();
        }
        try {
            if (res != null) {
                    res.close();
                }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("正常关闭");
        } catch (SQLException e) {
            System.out.println("关闭失败");
            e.printStackTrace();
        }
    }

}

