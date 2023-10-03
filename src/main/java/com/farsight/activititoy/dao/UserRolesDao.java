package com.farsight.activititoy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farsight.activititoy.entity.UserRoles;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色对应表 Mapper 接口
 * </p>
 *
 * @author farsight
 * @since 2023-09-02
 */
@Mapper
public interface UserRolesDao extends BaseMapper<UserRoles> {
}