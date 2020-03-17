package com.service.impl;

import com.dao.IItemDao;
import com.entity.Item;
import com.service.IItemService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("itemService")
public class ItemService implements IItemService{

    @Autowired
    private IItemDao dao;
    @Override
    public Integer selectCountUser(Integer vsId) {
        return dao.selectCountUser(vsId);
    }

    @Override
    public Integer insert(Item it) {
        return dao.insert(it);
    }

    @Override
    public int selectCountAllVote(Integer vsId) {
        return dao.selectCountAllVote(vsId);
    }

    @Override
    public int selectCountOneVote(Integer voId) {
        return dao.selectCountOneVote(voId);
    }
}
