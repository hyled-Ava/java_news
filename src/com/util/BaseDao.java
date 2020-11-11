package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    static {
        try {
            System.out.println("正在加载数据库驱动...");
            System.out.println("Class.forName(\"com.mysql.jdbc.Driver\");");

            Class.forName("com.mysql.jdbc.Driver");//这边参数的意义，url:jdbc数据库网址 user:用户名（String类型） password:密码（String类型）[这边的数据库密码和用户名填写自己的]。同样由于getConnection方法会抛出SQLException，要使用try-catch

            System.out.println("已加载数据库驱动！！！\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2、创建数据库连接的方法
    public Connection getConnection() {
        Connection connection;
        try {
            System.out.println("正在连接到数据库...");
            System.out.println("connection = DriverManager.getConnection('jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf8&useSSL=true', 'root', 'password');");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/news?useSSL=FALSE&serverTimezone=UTC", "root", "password");///这边参数的意义，url:jdbc数据库网址 user:用户名 password:密码。同样由于getConnection方法会抛出SQLException，要使用try-catch

            System.out.println("已连接到root数据库！！！\n");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //3、关闭数据库连接，释放JDBC资源的方法
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                System.out.println("准备释放jdbc资源，断开数据库连接...");
                System.out.println("connection.close();");

                connection.close();//立即释放jdbc资源，而不是等自动释放

                System.out.println("已断开数据库连接并且释放了jdbc资源\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
