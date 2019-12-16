package com.test;

import com.dao.UserDao;
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
import java.util.Date;
import java.util.List;

/**
 * @outhor li
 * @create 2019-12-13 18:43
 * 入门案例
 */
public class MybatisTest {
    InputStream in = null;
    SqlSession session = null;
    UserDao userDao = null;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SQLSession创建Dao代理对象
        userDao = session.getMapper(UserDao.class);
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
    public void testFindAll() throws IOException {
        //5.使用对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setAddress("西安");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("李昊波");
        userDao.saveUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(42);
        user.setAddress("山东");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("张浩华");
        userDao.updateUser(user);
    }

    @Test
    public void delUser(){
        userDao.delUser(49);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(48);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        System.out.println(userDao.findTotal());
    }
}
