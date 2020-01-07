package com.dao;

import com.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.junit.Test;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-04 20:37
 */
public interface AccountDao {
    /**
     * 查询所有账户，同时获取账户的所属用户名称以及它的地址信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid",one = @One(select = "com.dao.UserDao.findUserById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 通过uid查询
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(int uid);
}
