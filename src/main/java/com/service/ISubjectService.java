package com.service;

import java.util.*;
import com.entity.Subject;

public interface ISubjectService {
    List<Subject> selectAll();
    Integer selectCountOption(Integer vsId);
    int insert(Subject sub);
    int updateByPrimaryKey(Subject sub);
    Subject selectByPrimaryKey(Integer vsId);
}
