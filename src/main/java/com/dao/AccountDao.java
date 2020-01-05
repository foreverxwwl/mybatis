package com.dao;

import com.domain.Account;
import com.domain.AccountUser;

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
    List<Account> findAll();

    /**
     * 查询所有账户信息对应的人的信息
     */
    List<AccountUser> findAccountUser();
}
