package ambow.jiahao.dao;

import ambow.jiahao.pojo.TenancyList206;
import ambow.jiahao.util.DBCConnection206;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TenancyListDao206 {
    public int add206(TenancyList206 tenancyList206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        String insetSQL = "insert into t_tenancylist values(?,?,?,?,?)";
//      初始化
        int i = 0;

        try {
            preparedStatement = connection.prepareStatement(insetSQL);
            preparedStatement.setInt(1,tenancyList206.getBookID206());
            preparedStatement.setInt(2, tenancyList206.getBorrowDate206());
            preparedStatement.setFloat(3, tenancyList206.getBorrowMoney206());
            preparedStatement.setInt(4, tenancyList206.getState206());
            preparedStatement.setInt(5, tenancyList206.getBtNum206());
//            执行添加SQL语句并返回结果集
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

    public int update(TenancyList206 tenancyList206) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String updateSQL = "update t_tenancylist set bookid=?,borrowdate=?,state=?,bitd=?"
                + "where typeid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, tenancyList206.getBookID206());
            preparedStatement.setInt(2, tenancyList206.getBorrowDate206());
            preparedStatement.setFloat(3, tenancyList206.getBorrowMoney206());
            preparedStatement.setInt(4, tenancyList206.getState206());
            preparedStatement.setInt(5, tenancyList206.getBtNum206());
            preparedStatement.setInt(6,tenancyList206.getId206());
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
     * 通过id删除信息
     * @param listId
     * @return
     */
    public int delete(int  listId) {
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
        //添加新的SQL语句
        String deleteSQL = "delete from t_tenancylist where listid=?";
        //初始化
        int i = 0;
        try {
            //创建预处理对象
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, listId);
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
     * 通过各种方式查询id
     * @param btID
     * @param flag 哪一种方法
     * @param state
     * @return
     */
    public List<TenancyList206> getAllByBtID(int btID, boolean flag, int state) {
        List<TenancyList206> tenancyList206s = new ArrayList<TenancyList206>();
        String sql = "";
        if (flag) {
            sql = "select * from t_tenancyList where btid=?";
        } else sql = "select * from t_tenancyList where state=0 and btid=?";
        //创建数据库连接
        Connection connection = DBCConnection206.getDBCConnection206();
        //明预处理对象
        PreparedStatement preparedStatement = null;
//      转化后的结果集
        ResultSet resultSet=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, btID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TenancyList206 tenancyList206 = new TenancyList206();
                tenancyList206.setId206(resultSet.getInt(1));
                tenancyList206.setBookID206(resultSet.getInt(2));
                tenancyList206.setBorrowDate206(resultSet.getInt(3));
                tenancyList206.setBorrowMoney206(resultSet.getFloat(4));
                tenancyList206.setState206(resultSet.getInt(5));
                tenancyList206.setBtNum206(resultSet.getInt(6));
                tenancyList206s.add(tenancyList206);
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
        return tenancyList206s;
    }
}
