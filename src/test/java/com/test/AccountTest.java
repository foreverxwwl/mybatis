package com.test;

import com.dao.AccountDao;
import com.dao.UserDao;
import com.domain.Account;
import com.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @outhor li
 * @create 2020-01-04 21:07
 */
public class AccountTest {
        InputStream in = null;
        SqlSession session = null;
        UserDao userDao = null;
        AccountDao accountDao = null;

        @Before
        public void init() throws IOException {
            //1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象
            session = factory.openSession(true);
            //4.使用SQLSession创建Dao代理对象
            userDao = session.getMapper(UserDao.class);
            accountDao = session.getMapper(AccountDao.class);
        }

        @After
        public void destory() throws IOException {
            //提交事务，这样修改操作才有用 不会回滚
            session.commit();
            //6.释放资源
            session.close();
            in.close();
        }
        @Test
        public void testFindAll() {
            List<Account> accountList = accountDao.findAll();
            for (Account account :
                    accountList) {
                System.out.println(account);
                System.out.println(account.getUser());
            }
        }
        @Test
    public void testFindAccountUser(){
            List<AccountUser> accountUserList = accountDao.findAccountUser();
            for (AccountUser account :
                    accountUserList) {
                System.out.println(account);
            }
        }
}
