import com.dao.AccountDao;
import com.dao.UserDao;
import com.domain.Account;
import com.domain.User;
import org.apache.ibatis.annotations.Select;
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
 * @create 2020-01-05 20:14
 */
public class UserTest {
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

    /**
     * 查询所有用户
     */
    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
            for (Account account :
                    user.getAccounts()) {
                System.out.println(account);
            }
        }
    }

    /**
     * 通过id查询用户
     */
    @Test
    public void findUserById(){
        User user = userDao.findUserById(45);
        System.out.println(user);
    }

    /**
     * 保存用户
     */
    @Test
    public void saveUser(){
        User user = new User();
        user.setUsername("宋彪");
        user.setId(53);
        user.setSex("男");
        user.setAddress("西安");
        userDao.saveUser(user);
    }
    /**
     * 修改用户
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setUsername("宋彪");
        user.setId(53);
        user.setSex("男");
        user.setAddress("陕西西安");
        userDao.updateUser(user);
    }
    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){

        userDao.deleteUser(43);
    }
    /**
     * 模糊查询用户
     */
    @Test
    public void findUserByUsername(){

        List<User> users = userDao.findUserByUsername("%王%");
        for (User user :
                users) {
            System.out.println(user);
        }
    }
    /**
     * 查询用户总量
     */
    @Test
    public void findUserTotal(){
        System.out.println(userDao.findUserTotal());
    }

}
