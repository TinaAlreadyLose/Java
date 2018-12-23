package ambow.jiahao.dao;

import java.sql.*;
import java.util.*;

import ambow.jiahao.pojo.BookType206;
import ambow.jiahao.util.DBCConnection206;

public class BooksTypeDao206 {
    public int add206(BookType206 boookType206) {
        //获得数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            String insertSQL = "insert into t_booktype values(?,?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, boookType206.getTypeName206());
            preparedStatement.setFloat(2, boookType206.getPriceOfDay206());
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

    /**
     * 更新数据方法
     * @param booktype206  传入的数据类型
     * @return i    执行是否成功
     */
    public int update(BookType206 booktype206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String updateSQL = "update t_nooktype set typename=?,priceofday=?" + "where typeid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, booktype206.getTypeName206());
            preparedStatement.setFloat(2, booktype206.getPriceOfDay206());
            preparedStatement.setInt(3, booktype206.getTypeID206());
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

    /**
     * 删除数据方法
     * @param typeID  根据那个ID进行数据的删除
     * @return i  删除是否成功
     */
    public int delete(int  typeID) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String deleteSQL = "delete from t_booktype where typeid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, typeID);
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

    /**
     * 返回表中的所有数据
     * @return
     */
    public List<BookType206> getALL206() {
        List<BookType206> bookType206s = new ArrayList<BookType206>();
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet=null;
//        查询表中的全部数据
        String sql="select *form type t_booktype";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookType206 bookType206 = new BookType206();
                bookType206.setTypeID206(resultSet.getInt(1));
                bookType206.setTypeName206(resultSet.getString(2));
                bookType206.setPriceOfDay206(resultSet.getFloat(3));
                bookType206s.add(bookType206);
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
        return bookType206s;
    }

    /**
     * 根据表中的的ID来查询数据
     * @param typeID
     * @return
     */
    public  BookType206 getTypeNameByID206(int typeID) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet=null;
//        根据id来查询语句
        String sql = "select *from t_booktype where typeid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, typeID);
            if (resultSet.next()) {
                BookType206 bookType206 = new BookType206();
                bookType206.setTypeID206(resultSet.getInt(1));
                bookType206.setTypeName206(resultSet.getString(2));
                bookType206.setPriceOfDay206(resultSet.getFloat(3));
                return bookType206;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭预以处理对象
            DBCConnection206.closeStatement206(preparedStatement);
//            关闭数据库连接
            DBCConnection206.closeConnection206(connection);
//            关闭转化后的结果集
            DBCConnection206.closeResulSet206(resultSet);
        }
        return null;
    }
}
