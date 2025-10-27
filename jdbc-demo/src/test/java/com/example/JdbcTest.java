package com.example;

import org.example.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 获取执行sql语句的对象
        Statement statement = conn.createStatement();

        // 4. 执行sql语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1"); // DML
        System.out.println("SQL执行完毕，影响行数：" + i);

        // 5. 释放资源
        statement.close();
        conn.close();
    }

    @Test
    public void testSelect() {
        final String URL = "jdbc:mysql://localhost:3306/web01";
        String USER = "root";
        String PASSWORD = "1234";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 注册驱动（MySQL 5.1+之后可以省略该步骤）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3. 获取执行sql语句的对象
            String sql = "select * from user where username = ? and password = ?";
            stmt = conn.prepareStatement(sql);

            // 对?占位符赋值
            stmt.setString(1, "daqiao");
            stmt.setString(2, "123456");

            rs = stmt.executeQuery();

            while (rs.next()) {
                // 正确创建User对象并赋值
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));

                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {  // 修复变量名错误
                e.printStackTrace();
            }
        }
    }
}
