package com.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.*;
import com.service.*;
import com.dao.*;

@Service(value = "userService")
public class UserService implements IUserService {


    @Autowired
  private IUserDao dao;


    @Override
    public List<User> selectAll(Map<String, Object> mp) {
        return dao.selectAll();
    }

    @Override
    public int insert(User u) {
        return dao.insert(u);
    }

    @Override
    public User selectNandP(User u) {
        return dao.selectNandP(u);
    }

    @Override
    public User selectName(String vuUserName) {
        return dao.selectName(vuUserName);
    }
}
