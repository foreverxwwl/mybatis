package com.test;

import com.dao.UserDao;
import com.dao.daoImpl.UserDaoImpl;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @outhor li
 * @create 2019-12-18 19:32
 * 测试以dao实现类方式实现查询
 */
public class ImplTest {
    @Test
    public void testFindAll() throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //生成工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建dao对象
        UserDao userDao = new  UserDaoImpl(factory);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        in.close();

    }
}
