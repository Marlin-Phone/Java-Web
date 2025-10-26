package com.example.springbootweb01.controller;

import com.example.springbootweb01.pojo.User;
import com.example.springbootweb01.service.UserService;
import com.example.springbootweb01.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list2(){
        List<User> userList = userService.list();
        return userList;
    }

//    public List<User> list() throws Exception {
//        // 1. 加载并读取user.txt文件并获取用户数据
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        // 2. 解析用户信息，封装为User对象->list集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//
//        }).toList();
//        // 3. 给前端返回数据(json)
//        return userList;
//    }
}
