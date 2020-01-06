package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-13 1:11
 */
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    /**
     * 通过id查找用户
     */
    List<User> findUserById(int id);
}
