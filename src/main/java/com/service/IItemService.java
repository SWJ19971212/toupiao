package com.service;

import com.entity.Item;

public interface IItemService {
    Integer selectCountUser(Integer vsId);
    Integer insert(Item it);
    //总票数
    int selectCountAllVote(Integer vsId);
    //单选项的票数
    int selectCountOneVote(Integer voId);
}
