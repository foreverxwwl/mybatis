package com.dao.daoImpl;

import com.dao.UserDao;
import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-18 19:23
 */
//public class UserDaoImpl implements UserDao {
//    private SqlSessionFactory factory;
//
//    public UserDaoImpl(SqlSessionFactory factory){
//        this.factory = factory;
//    }
//
//    public List<User> findAll() {
//        //根据factory获取SqlSession对象
//        SqlSession session = factory.openSession();
//        //调用SqlSession中的方法，实现查询列表
//        List<User> users = session.selectList("com.dao.UserDao.findAll");
//        //关闭资源
//        session.close();
//        return users;
//    }
//
//    public void saveUser(User user) {
//
//    }
//
//    public void updateUser(User user) {
//
//    }
//
//    public void delUser(Integer id) {
//
//    }
//
//    public User findUserById(Integer id) {
//        return null;
//    }
//
//    public List<User> findUserByName(QueryVo queryVo) {
//        return null;
//    }
//
//    public int findTotal() {
//        return 0;
//    }
//}
