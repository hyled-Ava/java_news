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
        String sql = "select * from news where ispass=1";
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
        String sql;
        //1.连接到数据库
        Connection connection = db.getConnection();
        //2.拼接sql语句

        try {
            for (String id : ids) {
                sql = "delete from news where id=" + id;
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
        String sql = "update news set title='" + news.getTitle() + "',content='" + news.getContent() + "'  where id=" + news.getId();
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

    //单个更改
    public int updateNews(int newsid, String title, String content) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update news set title='" + title + "',content='" + content + "'  where id=" + newsid;
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

    public int updateispass(String[] newsids) {
        int count = 0;
        Connection connection = db.getConnection();

        String sql;
        try {
            Statement st = connection.createStatement();
            for (int i = 0; i < newsids.length; i++)   //循环操作
            {

                sql = "update news set ispass=1  where id=" + newsids[i];
                System.out.println("准备更新 id 为 " + newsids[i] + "的记录...");
                System.out.println("sql");
                System.out.println(sql);
                System.out.println();

                count = st.executeUpdate(sql);

                if (count != 0) {
                    System.out.print("更新成功！！！ ");
                } else {
                    System.out.print("update error!!! ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(connection);
        }
        return count;
    }
}
