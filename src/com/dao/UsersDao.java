package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Users;
import com.util.BaseDao;

public class UsersDao {
    BaseDao db = new BaseDao();//初始化工具类
    String sql = "select * from Users";//封装sql语句，这边的‘Users’要和数据库中的表 同名

    /**
     * 查询方法
     *
     * @return
     */
    public List<Users> findUsers() {
        List<Users> users = new ArrayList<Users>();//初始化list
        //1、连接到数据库
        Connection connection = db.getConnection();

        try {
            //2、执行SQL查询
            PreparedStatement pst = connection.prepareStatement(sql);
            //3、把查询结果放到结果集
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                users.add(user);
            }//循环将结果保存到list中。 使用rs.get***()获取到结果集里面的相应类型的每一列的值，然后通过构造方法赋值给user，进而通过add()保存到list
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4、断开数据库连接
            db.closeConnection(connection);//放到finally中，无论是否抛出异常，最后都会执行该语句
        }
        return users;
    }

    /**
     * 唯一查询
     *
     * @param id 通过id唯一查询数据库中的数据 [注：唯一查询的时候是
     *           根据id查询的，所以要把数据库中的表的id字段设置为primary key]
     * @return Users的一个实例化对象, 如果查找到了就返回的是数据库中
     * 的一条记录
     * 否则就是 null;
     */
    public Users selectById(int id) {
        Users user = new Users();
        //1.连接到数据库
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "select * from users where id=" + id;
        System.out.println(sql);
        try {
            System.out.println("准备查询....");

            //3.执行发送到数据库的sql语句
            Statement st = connection.createStatement();//创建一个Statement对象，用于向数据库发送数据
            ResultSet rs = st.executeQuery(sql);//执行给定的sql语句,返回结果集对象
            while (rs.next()) {
                user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getInt(7));
                //执行SQL语句查找到了数据，就把数据和实体类的一个对象映射起来。
            }

            System.out.println("已查询！！！！");
            System.out.println("user.getSex()");
            System.out.println(user.getSex());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接，释放资源
            db.closeConnection(connection);
        }
        return user;
    }

    /**
     * 删除
     *
     * @param id
     * @return 删除的记录数--如果删除一条记录就返回1，若是没有删除成功则返回0
     */
    public int delete(int id) {
        int count = 0;
        //1.连接到数据库
        Connection connection = db.getConnection();
        //2.拼接sql语句
        String sql = "delete from users where id=" + id;
        try {
            System.out.println("准备删除id为：" + id + " 的记录...");

            //3.执行发送到数据库的sql语句
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
            //4.关闭数据库连接，释放资源
            db.closeConnection(connection);
        }
        return count;
    }

    /**
     * 插入
     *
     * @param user Users类的对象，插入数据库的是该条记录
     * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有插入成功则返回0
     */
    public int insert(Users user) {
        int count = 0;
        Connection connection = db.getConnection();
//        String sql = "insert into users(id, username, password,sex,hoby,name,ispass) values(" + user.getid() + ", '" + user.getUsername() + "', '" + user.getpassword() + "', '" + user.getSex() + "','" + user.gethoby() + "'," + user.getname() + "'," + user.getispass() + ")";
        String sql = "insert into users(username, password,sex,hoby,name) values('" + user.getUsername() + "','" + user.getpassword() + "','" + user.getSex() + "','" + user.gethoby() + "','" + user.getname() + "')";

        try {
            System.out.println("准备插入记录===" + ":" + user.getUsername() + ":" + user.getpassword() + "...");

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

    /**
     * 更新
     *
     * @param user Users类的对象，从数据库更新的是该条记录
     * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有更新成功则返回0
     */
    public int update(Users user) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update users set password='" + user.getpassword() + "' where id=" + user.getid();

        try {
            System.out.println("准备更新 id 为 " + user.getid() + "的记录...");
            System.out.println("sql");
            System.out.println(sql);

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

    public int updates(Users user) {
        int count = 0;
        Connection connection = db.getConnection();
        String sql = "update users set name='" + user.getname() + "',sex='" + user.getSex() + "',hoby='" + user.gethoby() + "' " + " where id=" + user.getid();

        try {
            System.out.println("准备更新 id 为 " + user.getid() + "的记录...");
            System.out.println("sql");
            System.out.println(sql);

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

    public int check(String username, String password) {
        Users user = new Users();
        Connection connection = db.getConnection();
        String sql = "select * from users where username='" + username + "' and password='" + password + "'";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                int id = rs.getInt(1);
                int ids = rs.getInt("id");

                System.out.println(id);
                System.out.println(ids);
                db.closeConnection(connection);
                return id;

            } else {
                System.out.println("密码错误");
                db.closeConnection(connection);
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

