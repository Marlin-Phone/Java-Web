package com.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
        int i = statement.executeUpdate("update user set age = 20 where id = 1"); // DML
        System.out.println("SQL执行完毕，影响行数：" + i);

        // 5. 释放资源
        statement.close();
        conn.close();
    }
}
