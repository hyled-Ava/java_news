package com.dao;

import com.Message;
import com.util.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    BaseDao db = new BaseDao();

    public List<Message> findMessage() {
        List<Message> messages = new ArrayList<Message>();
        String sql = "select * from news_mes";
        Connection connection = db.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Message message = new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return messages;
    }

    public Message selectById(int id) {
        Message message = new Message();
        Connection connection = db.getConnection();
        String sql = "select * from news_mes where id=" + id;
        try {
            System.out.println("准备查询....");
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                message = new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            System.out.println("已查询！！！！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return message;
    }

    public int delete(int id) {
        int count = 0;
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "delete from news_mes where id=" + id;
        try {
            System.out.println("准备删除id为：" + id + " 的记录...");
            Statement st = connection.createStatement();
            count = st.executeUpdate(sql);//count接收方法的返回值，为0 表示删除失败
            if (count != 0) {
                System.out.print("删除成功！！！ ");
            } else {
                System.out.print("delete error!!! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return count;
    }

    public int insert(Message message) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "insert into news_mes(id,filename,create_time,publish_time,username) values(" + message.getId() + ",'" + message.getFilename() + "','" + message.getCreate_time() + "','" + message.getPublish_time() + "','" + message.getUsername() + "')";
        try {
            System.out.println("准备插入记录===" + message.getId() + ":" + message.getFilename() + ":" + message.getCreate_time() + "...");
            Statement st = connection.createStatement();
            count = st.executeUpdate(sql);

            if (count != 0) {
                System.out.print("插入成功！！！ ");
            } else {
                System.out.print("insert error!!! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return count;
    }

    public int update(Message message) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update news_mes set create_time='" + message.getCreate_time() + "',publish_time='" + message.getPublish_time() + "',filename='" + message.getFilename() + "' where id=" + message.getId();
        try {
            System.out.println("准备更新 id 为 " + message.getId() + "的记录...");

            Statement st = connection.createStatement();
            count = st.executeUpdate(sql);

            if (count != 0) {
                System.out.print("更新成功！！！ ");
            } else {
                System.out.print("update error!!! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return count;
    }
}
