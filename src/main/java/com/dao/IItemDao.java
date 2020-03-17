package com.dao;

import com.entity.Item;

public interface IItemDao {
    Integer selectCountUser(Integer vsId);
    Integer insert(Item it);

    //总票数
    int selectCountAllVote(Integer vsId);
    //单选项的票数
    int selectCountOneVote(Integer voId);
}
