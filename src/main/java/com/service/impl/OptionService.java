package com.service.impl;


import com.dao.IOptionDao;
import com.entity.Option;
import com.service.IOptionService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("optionService")
@MapperScan(value = "com.dao")
public class OptionService implements IOptionService{
    @Autowired
    private IOptionDao dao;

    @Override
    public int insert(Option op) {
        return dao.insert(op);
    }

    @Override
    public int updateByPrimaryKey(Option op) {
        return dao.updateByPrimaryKey(op);
    }

    @Override
    public List<Option> selectByVsId(Integer vsId) {
        return dao.selectByVsId(vsId);
    }

    @Override
    public Option selectByOp(String voOption,Integer  vsId) {
        return dao.selectByOp(voOption,vsId);
    }

}
