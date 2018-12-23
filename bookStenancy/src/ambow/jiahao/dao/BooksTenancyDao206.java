package ambow.jiahao.dao;

import ambow.jiahao.pojo.BooksTenancy206;
import ambow.jiahao.util.DBCConnection206;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksTenancyDao206 {
    /**
     * 数据库添加信息
     *1
     * @param booksTenancy206 传入的参数
     * @return 返回添加是否成功
     */
    public int add206(BooksTenancy206 booksTenancy206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//    sql 查询语句
        String insertSQL = "insert into t_bookstenancy values(?,?)";
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, booksTenancy206.getUserName206());
            preparedStatement.setString(2, booksTenancy206.getTenancyDate206());
//            执行sql语句并返回结果
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭预以处理对象
            DBCConnection206.closeStatement206(preparedStatement);
//            关闭数据库连接
            DBCConnection206.closeConnection206(connection);
        }
        return i;
    }
    public int update(BooksTenancy206 booksTenancy206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String updateSQL = "update t_bookstenancy set username=?,[tenancyDaate]=?" + "where typeid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, booksTenancy206.getUserName206());
            preparedStatement.setString(2, booksTenancy206.getTenancyDate206());
            preparedStatement.setInt(3, booksTenancy206.getBtNum206());
//            执行添加SQL语句并返回添加结果
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭预以处理对象
            DBCConnection206.closeStatement206(preparedStatement);
//            关闭数据库连接
            DBCConnection206.closeConnection206(connection);
        }
        return i;
    }
    public int delete(int  BtID) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String deleteSQL = "delete from t_bookstenancy where btid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, BtID);
//            执行添加SQL语句并返回添加结果
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭预以处理对象
            DBCConnection206.closeStatement206(preparedStatement);
//            关闭数据库连接
            DBCConnection206.closeConnection206(connection);
        }
        return i;
    }
    public List<BooksTenancy206> getALL206() {
        List<BooksTenancy206> booksTenancy206s = new ArrayList<BooksTenancy206>();
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet=null;
//        查询表中的全部数据
        String sql="select *form type t_bookstenancy";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BooksTenancy206 booksTenancy206 = new BooksTenancy206();
                booksTenancy206.setBtNum206(Integer.parseInt(resultSet.getString(1)));
                booksTenancy206.setUserName206(resultSet.getString(2));
                booksTenancy206.setTenancyDate206(resultSet.getString(3));
                booksTenancy206s.add(booksTenancy206);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭预以处理对象
            DBCConnection206.closeStatement206(preparedStatement);
//            关闭数据库连接
            DBCConnection206.closeConnection206(connection);
//            关闭转化后的结果集
            DBCConnection206.closeResulSet206(resultSet);
        }
        return booksTenancy206s;
    }
}


