package ambow.jiahao.dao;

import ambow.jiahao.pojo.Book206;
import ambow.jiahao.util.DBCConnection206;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDao206 {
    public int add206(Book206 book206) {
        //获得数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        PreparedStatement preparedStatement = null;
        String insertSQL = "insert into t_books values(?,?,?,?,?,?)";
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, book206.getBookType206());
            preparedStatement.setString(2, book206.getBookName206());
            preparedStatement.setFloat(3, book206.getBookPrice206());
            preparedStatement.setString(4, book206.getBookPublisher206());
            preparedStatement.setString(5, book206.getBookAuthor206());
            preparedStatement.setInt(6, book206.getBookStock206());
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
     *
     * @param book206 传入的数据类型
     * @return i    执行是否成功
     */
    public int update(Book206 book206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String updateSQL = "update t_books set booktype=?,bookname=?,bookprice=?," +
                "bookPublisher=?,bookauthor=?,bookStock=?" + "where typeid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, book206.getBookType206());
            preparedStatement.setString(2, book206.getBookName206());
            preparedStatement.setFloat(3, book206.getBookPrice206());
            preparedStatement.setString(4, book206.getBookPublisher206());
            preparedStatement.setString(5, book206.getBookAuthor206());
            preparedStatement.setInt(6, book206.getBookStock206());
            preparedStatement.setInt(7, book206.getId206());
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
     *
     * @param bookID 根据那个ID进行数据的删除
     * @return i  删除是否成功
     */
    public int delete(int bookID) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String deleteSQL = "delete from t_books where bookid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, bookID);
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
     *
     * @return
     */
    public List<Book206> getALL206() {
        List<Book206> book206s = new ArrayList<Book206>();
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet = null;
//        查询表中的全部数据
        String sql = "select *form type t_books ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book206 book206 = new Book206();
                book206.setId206(Integer.parseInt(resultSet.getString(1)));
                book206.setBookType206(resultSet.getInt(2));
                book206.setBookName206(resultSet.getString(3));
                book206.setBookPrice206(resultSet.getFloat(4));
                book206.setBookPublisher206(resultSet.getString(5));
                book206.setBookAuthor206(resultSet.getString(6));
                book206.setBookStock206(resultSet.getInt(7));
                book206s.add(book206);
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
        return book206s;
    }

    /**
     * 根据表中的的ID来查询数据
     *
     * @param bookID
     * @return
     */
    public Book206 getTypeNameByID206(int bookID) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet = null;
//        根据id来查询语句
        String sql = "select *from t_books where bookid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book206 book206 = new Book206();
                book206.setId206(Integer.parseInt(resultSet.getString(1)));
                book206.setBookType206(resultSet.getInt(2));
                book206.setBookName206(resultSet.getString(3));
                book206.setBookPrice206(resultSet.getFloat(4));
                book206.setBookPublisher206(resultSet.getString(5));
                book206.setBookAuthor206(resultSet.getString(6));
                book206.setBookStock206(resultSet.getInt(7));
                return book206;
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
        return null;
    }

    public List<Book206> getBooksByTypeID206(int bookID) {
        List<Book206> book206s = new ArrayList<Book206>();
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet = null;
//        根据id来查询语句
        String sql = "select *from t_books where booktype=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book206 book206 = new Book206();
                book206.setId206(Integer.parseInt(resultSet.getString(1)));
                book206.setBookType206(resultSet.getInt(2));
                book206.setBookName206(resultSet.getString(3));
                book206.setBookPrice206(resultSet.getFloat(4));
                book206.setBookPublisher206(resultSet.getString(5));
                book206.setBookAuthor206(resultSet.getString(6));
                book206.setBookStock206(resultSet.getInt(7));
                book206s.add(book206);
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
        return book206s;
    }
}
