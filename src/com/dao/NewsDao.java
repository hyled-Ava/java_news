package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.News;
import com.util.BaseDao;

public class NewsDao {
    BaseDao db = new BaseDao();

    public List<News> findNews() {
        List<News> news = new ArrayList<News>();
        String sql = "select * from News";
        Connection connection = db.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                News ne = new News(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getInt(4), rs.getInt(5));
                news.add(ne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return news;
    }

    public News selectById(int id) {
        News news = new News();
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "select * from news where id=" + id;
        try {
            System.out.println("准备查询....");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                news = new News(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getInt(4), rs.getInt(5));
            }
            System.out.println("已查询！！！！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return news;
    }

    public List<News> selectByuserid(int userid) {
        List<News> news = new ArrayList<>();
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "select * from news where userid=" + userid + " and ispass=0";
        try {
            System.out.println("准备查询....");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                News ne = new News(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getInt(4), rs.getInt(5));
                news.add(ne);
            }
            System.out.println("已查询！！！！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return news;
    }

    public List<News> selectByuserids(int userid) {
        List<News> news = new ArrayList<>();
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "select * from news where userid=" + userid;
        try {
            System.out.println("准备查询....");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                News ne = new News(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getInt(4), rs.getInt(5));
                news.add(ne);
            }
            System.out.println("已查询！！！！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return news;
    }

    public int delete(String[] ids) {
        int count = 0;
        //1.连接到数据库
        Connection connection = db.getConnection();
        //2.拼接sql语句

        try {
            for (String id : ids) {
                String sql = "delete from news where id=" + id;
                System.out.println("准备删除id为：" + id + " 的记录...");
                Statement st = connection.createStatement();
                count = st.executeUpdate(sql);//count接收方法的返回值，为0 表示删除失败
                if (count != 0) {
                    System.out.print("删除成功！！！ ");
                } else {
                    System.out.print("delete error!!! ");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return count;
    }

    public int insert(News news) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "insert into news(title,content,userid) values ('" + news.getTitle() + "','" + news.getContent() + "'," + news.getuserid() + ")";
        try {
            System.out.println("准备插入记录===" + news.getId() + ":" + news.getTitle() + ":" + news.getContent() + "...");
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

    public int update(News news) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update users set title='" + news.getTitle() + "',content='" + news.getContent() + "'  where id=" + news.getId();
        try {
            System.out.println("准备更新 id 为 " + news.getId() + "的记录...");

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


    public int updateispass(int newsid) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update users set ispass=1  where id=" + newsid;
        try {
            System.out.println("准备更新 id 为 " + newsid + "的记录...");

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
