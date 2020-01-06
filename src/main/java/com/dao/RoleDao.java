package com.dao;

import com.domain.Role;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-05 15:42
 */
public interface RoleDao {
    /**
     * 通过身份查询对应的人的信息  多对多查询
     */
    List<Role> findAll();
}
