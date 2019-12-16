package com.dao;

import com.domain.User;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-13 1:11
 */
public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void delUser(Integer id);

    User findUserById(Integer id);

    List<User> findUserByName(String name);

    int findTotal();
}
