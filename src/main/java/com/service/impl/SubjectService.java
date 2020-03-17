package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "subjectService")
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectDao dao;
    @Override
    public List<Subject> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Integer selectCountOption(Integer vsId) {
        return dao.selectCountOption(vsId);
    }

    @Override
    public int insert(Subject sub) {
        return dao.insert(sub);
    }

    @Override
    public int updateByPrimaryKey(Subject sub) {
        return dao.updateByPrimaryKey(sub);
    }

    @Override
    public Subject selectByPrimaryKey(Integer vsId) {
        return dao.selectByPrimaryKey(vsId);
    }
}
