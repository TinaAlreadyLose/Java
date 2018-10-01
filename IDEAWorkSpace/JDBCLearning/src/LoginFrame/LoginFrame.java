package LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame {
    private final String PROP_FILE = "mysql.ini";
    private String driver;/*连接java中的数据库驱动*/
    private String url;/*服务器的连接地址*/
    private String username;/*用户名*/
    private String password;/*密码*/
    //    登入界面
    private JFrame jFrame = new JFrame("Login");
    private JTextField usejTField = new JTextField(20);
    private JTextField passJTFiled = new JTextField(20);
    private JButton loginJButton = new JButton("Login");
    //    执行JDBC操作
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //    默认连接mysql的test数据库
    public LoginFrame() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT";
        this.username = "root";
        this.password = "123456";
    }
//    自定义连接数据库

    public LoginFrame(String driver, String url, String username, String password) {
        this.url = url;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    //      为事件加载监听按钮
    private boolean validate(String username, String password) {
//        try {
//            Class.forName(this.driver);
//            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
//            statement =connection.createStatement();
//            String SQL="select * from jdbc_test "
//                    +"where jdbc_name='"+username
//                    +"' and jdbc_desc='"+password+"';";
//            System.out.println(SQL);
//            if(statement.executeQuery(SQL).next())
//                return true;

//
//        } catch (ClassNotFoundException e) {
//            System.out.println("数据库驱动加载失败");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("数据库连接失败");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null)
//                    resultSet.close();
//                if (statement != null)
//                    statement.close();
//                if (connection != null)
//                    connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//        return false;
        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            preparedStatement = connection.prepareStatement("select * from jdbc_test "
                    + "where jdbc_name=? and  jdbc_desc=?");
            System.out.println("select * from jdbc_test "
                    + "where jdbc_name=? and  jdbc_desc=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            if (preparedStatement.executeQuery().next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return  false;
    }

    public void init() {
        loginJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validate(usejTField.getText(), passJTFiled.getText())) {
                    JOptionPane.showMessageDialog(jFrame, "登入成功");
                } else JOptionPane.showMessageDialog(jFrame, "登录失败");
            }
        });
//      https://blog.csdn.net/qwezhaohaihong/article/details/72846899
//        BorderLayout详细介绍
        jFrame.add(usejTField, BorderLayout.NORTH);
        jFrame.add(passJTFiled);
        jFrame.add(loginJButton, BorderLayout.SOUTH);
        jFrame.pack();
//       setVisible：参考： https://zhidao.baidu.com/question/281472543.html
        jFrame.setVisible(true);
    }

}

