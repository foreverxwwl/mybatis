package com.test;

import com.dao.AccountDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.domain.Role;
import com.domain.User;
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
 * @create 2020-01-05 16:09
 */
public class RoleTset {
    InputStream in = null;
    SqlSession session = null;
    UserDao userDao = null;
    AccountDao accountDao = null;
    RoleDao roleDao = null;

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
        roleDao = session.getMapper(RoleDao.class);
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
    public void findAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role :
                roles) {
            System.out.println(role);
            for (User user :
                    role.getUsers()) {
                System.out.println(user);
            }
        }
    }
}
