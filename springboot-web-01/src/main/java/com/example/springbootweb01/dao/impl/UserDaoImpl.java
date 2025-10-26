package com.example.springbootweb01.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.example.springbootweb01.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> list(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = (ArrayList)IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList());
        return lines;
    }

}
