package com.service;
import java.util.*;

import com.entity.*;
public interface IUserService {
    List<User> selectAll(Map<String, Object>mp);
    int insert(User u);
    User selectNandP(User u);

    User selectName(String vuUserName);
}
