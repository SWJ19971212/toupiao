package com.dao;

import java.util.*;
import com.service.*;
import com.entity.*;


public interface ISubjectDao {
    List<Subject> selectAll();

    Subject selectByPrimaryKey(Integer vsId);

    Integer selectCountOption(Integer vsId);

    int insert(Subject sub);

    int updateByPrimaryKey(Subject sub);

}
