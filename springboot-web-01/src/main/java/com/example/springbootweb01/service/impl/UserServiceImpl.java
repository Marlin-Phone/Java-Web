package com.example.springbootweb01.service.impl;

import com.example.springbootweb01.dao.UserDao;
import com.example.springbootweb01.dao.impl.UserDaoImpl;
import com.example.springbootweb01.pojo.User;
import com.example.springbootweb01.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
        // 1.调用DAO
        private UserDao userDao = new UserDaoImpl();

        @Override
        public List<User> list(){
            //1.调用DAO
            List<String> lines = userDao.list();
            List<User> userList = lines.stream().map(line ->{
                String[] parts = line.split(",");
                Integer id = Integer.parseInt(parts[0]);
                String username = parts[1];
                String password = parts[2];
                String name = parts[3];
                Integer age = Integer.parseInt(parts[4]);
                LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                return new User(id, username, password, name, age, updateTime);
            }).collect(Collectors.toList());

            return userList;
        }


}
