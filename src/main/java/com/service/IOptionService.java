package com.service;

import com.entity.Option;

import java.util.List;

public interface IOptionService {
    int insert(Option op);
    int updateByPrimaryKey(Option op);
    List<Option> selectByVsId(Integer vsId);
    Option selectByOp(String voOption,Integer vsId);
}
