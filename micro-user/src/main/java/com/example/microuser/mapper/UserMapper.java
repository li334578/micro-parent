package com.example.microuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.microcommon.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description 用户mapper
 * @Author Wenbo Li
 * @Date 12/9/2022 下午 1:05
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
