package com.dao;

import java.util.*;
import com.service.*;
import com.entity.*;
import org.apache.ibatis.annotations.Param;

public interface IOptionDao {
    int insert(Option op);
    int updateByPrimaryKey(Option op);
    List<Option> selectByVsId(Integer vsId);
    Option selectByOp(@Param(value ="voOption") String voOption,@Param(value ="vsId")Integer vsId);
}
