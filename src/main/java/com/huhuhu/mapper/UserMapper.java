package com.huhuhu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huhuhu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    List<User> selectAll();

}
