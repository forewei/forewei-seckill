package com.forewei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forewei.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
