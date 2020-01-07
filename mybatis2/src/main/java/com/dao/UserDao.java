package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-13 1:11
 */
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap" ,value = {
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address" ,property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.dao.AccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    public List<User> findAll();

    /**
     * 通过id查找用户
     */
    @Select("select * from user where id = #{id}")
    public User findUserById(int id);

    /**
     * 保存用户
     */
    @Insert("insert into user(username,address,sex) values(#{username},#{address},#{sex})")
    public void saveUser(User user);

    /**
     * 修改用户
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    public void updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{id}")
    public void deleteUser(int id);

    /**
     * 模糊查询用户
     */
    @Select("select * from user where username like #{username}")
    public List<User> findUserByUsername(String username);

    /**
     * 查询用户总量
     */
    @Select("select count(*) from user")
    public int findUserTotal();
}
