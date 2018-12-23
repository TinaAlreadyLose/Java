package ambow.jiahao.util;

import java.sql.*;

/**
 * 该类主要用于数据库的连接
 *
 * @author GreenDan
 * @version 1.0.0.206
 * @Date 2018.12.22
 */
public class DBCConnection206 {
    private final static String DRIVER_Name = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=bookstenancy";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "123456";

    /**
     * 获取到数据库的连接方法
     *
     * @return 返回Connection的抽象连接
     */
    public static Connection getDBCConnection206() {

        Connection connection206 = null;
        try {
            Class.forName(DRIVER_Name);
            connection206 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection206;
    }

    /**
     * 关闭数据库的方法
     *
     * @param connection        数据来的连接
     */
    public static void closeConnection206(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 /**
  * @param preparedStatement 数据库数据库的预处理类
  *
  */
    public static void closeStatement206(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param resultSet 数据库的查询的结果集
     */
    public static void closeResulSet206(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Connection demo = getDBCConnection206();
            PreparedStatement preparedStatement = demo.prepareStatement("select  * from t_booktype");
            ResultSet resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= col; i++) {
                    if (i == 1)
                        System.out.print("|" + resultSet.getString(i) + "|");
                    else System.out.print(resultSet.getString(i) + "|");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

