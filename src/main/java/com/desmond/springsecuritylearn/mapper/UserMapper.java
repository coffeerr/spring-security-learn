package com.desmond.springsecuritylearn.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.desmond.springsecuritylearn.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author desmond
 * @since 2023-07-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
