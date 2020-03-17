package com.dao;
import java.util.*;

import com.entity.*;
public interface IUserDao {
    List<User> selectAll();
    User selectNandP(User u);
    int insert(User u);
    User selectName(String vuUserName);
}
