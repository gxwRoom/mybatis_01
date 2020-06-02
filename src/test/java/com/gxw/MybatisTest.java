package com.gxw;

import com.gxw.mapper.AccountMapper;
import com.gxw.mapper.UserMapper;
import com.gxw.pojo.Account;
import com.gxw.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 * @author GXW工作室
 * @date 2020/6/1 0001 - 21:41
 */
public class MybatisTest {
    /**
     * 完成的功能：
     * 1.查询
     * 1.查询所有用户
     * 2.分页查询用户
     * 3.根据id查询用户对象
     * 4.查询总数
     * 5.根据名称模糊查询
     * 2.添加
     * 3.更新
     * 4.删除
     *
     * @param
     * @throws Exception
     */

//    public static void main(String[] args) throws Exception {
//        //1.读取配置文件mybatis.xml
//        InputStream in = Resources.getResourceAsStream("mybatis.xml");
//        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.使用SqlSession创建mapper接口的代理对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
    //5.使用代理对象执行方法
    //1.查询用户
    //0.根据id查询用户对象
//                 User userById = userMapper.findUserById(41);
//                 System.out.printf("根据id查询用户对象："+userById);
    //1.查询所有用户
//                 List<User> userList = userMapper.findUser();
//                 for (User user : userList) {
//                    System.out.println("查询所有用户：" + user);
//                 }
    //2.分页查询用户
//                int pageSize=2;
//                int pageNumber=2;
//                Map<String,Object> map = new HashMap<>();
//                map.put("pageSize",pageSize);
//                map.put("pageStart",pageSize*(pageNumber-1));
//                List<User> userPage = userMapper.findUserPage(map);
//                System.out.println("分页查询用户："+userPage);
    //3.根据名称模糊查询
//                List<User> userByName = userMapper.findUserByName("%张%");
//                System.out.printf("根据名称模糊查询："+userByName);
    //4.查询总数
//                int total = userMapper.findTotal();
//                System.out.printf("查询总数："+total);

    //2.添加用户
//            User user = new User();
//            user.setUsername("张三");
//            user.setSex("男");
//            user.setAddress("广州市天河区");
//            user.setBirthday(new Date());
//            userMapper.addUser(user);

    //3.更新用户
//            User user = new User();
//            user.setAddress("湖北武汉市");
//            int updateUser = userMapper.updateUser(user);
//            System.out.printf("更新用户："+updateUser);

    //4.根据id删除用户
//            List<User> userLists = userMapper.findUser();
//            System.out.println("删除之前查询："+userLists);
//            int deleteUserById = userMapper.deleteUserById(53);
//            System.out.printf("根据id删除用户成功："+deleteUserById);

    //6.关闭数据
//        session.commit();
//        session.close();
//        in.close();
//    }




/**
 * 完成的功能：
 * 1.查询
     * 1.查询所有用户
     * 2.分页查询用户
        * 首先：先创建数据库
        * 其次：编写sql语句 select * from user limit 0,2;
        * 最后：实现分页查询
     * 3.根据id查询用户对象
     * 4.查询总数
     * 5.根据名称模糊查询
 * 2.添加
 * 3.更新
 * 4.删除
 */
    //定义全局变量
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserMapper userMapper;
    private AccountMapper accountMapper;

//    @Before //在测试之前执行方法
//    public void init() throws Exception {
//        //1.读取配置文件mybatis.xml
//        in = Resources.getResourceAsStream("mybatis.xml");
//        //2.创建SqlSessionFactory工厂
//        builder = new SqlSessionFactoryBuilder();
//        factory = builder.build(in);
//        //3.使用工厂生产SqlSession对象
//        session = factory.openSession();
//        //4.使用SqlSession创建mapper接口的代理对象
//        userMapper = session.getMapper(UserMapper.class);
//    }

    @Before //在测试之前执行方法
    public void init() throws Exception {
        //1.读取配置文件mybatis.xml
        in = Resources.getResourceAsStream("mybatis.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建mapper接口的代理对象
        userMapper = session.getMapper(UserMapper.class);
        accountMapper = session.getMapper(AccountMapper.class);
    }

    @Test //5.执行查询方法测试
    public void findUserAllTest() {
        //1.查询所有用户
        List<User> userList = userMapper.findUser();
        for (User user : userList) {
             System.out.println("查询所有用户：" + user);
        }
    }

    @Test
    public void findUserPageTest() {
        //2.分页查询用户
        int pageSize=2;
        int pageNumber=2;
        Map<String,Object> map = new HashMap<>();
        map.put("pageSize",pageSize);
        map.put("pageStart",pageSize*(pageNumber-1));
        List<User> userPage = userMapper.findUserPage(map);
        System.out.println("分页查询用户："+userPage);
    }

    @Test
    public void findUserByIdTest(){
        //2.根据id查询
        User userById = userMapper.findUserById(41);
        System.out.printf("根据id查询用户对象："+userById);
    }

    @Test
    public void findUserByNameTest(){
        //3.根据名称模糊查询
        List<User> userByName = userMapper.findUserByName("%张%");
        System.out.printf("根据名称模糊查询："+userByName);
    }

    @Test
    public void findTotalTest(){
        //4.查询总数
        int total = userMapper.findTotal();
        System.out.printf("查询总数："+total);
    }

    @Test //执行添加方法测试
    public void addUserTest(){
        User user = new User();
        user.setUsername("王小五");
        user.setSex("男");
        user.setAddress("湖北省武汉市");
        user.setBirthday(new Date());
        userMapper.addUser(user);
    }

    @Test //执行更新方法测试
    public void updateUserTest(){
        //00.先获取id
        User user = userMapper.findUserById(53);
        //01.再根据id更新用户
        user.setAddress("湖北武汉市");
        int updateUser = userMapper.updateUser(user);
        System.out.printf("更新用户："+updateUser);
    }

    @Test //执行删除方法测试
    public void deleteUserTest(){
        List<User> userLists = userMapper.findUser();
        System.out.println("删除之前查询："+userLists);
        int deleteUserById = userMapper.deleteUserById(54);
        System.out.printf("根据id删除用户成功："+deleteUserById);
    }

    @Test //执行查询账号，同时查询用户信息方法测试  实现一对一
    public void findAccountTest(){
        List<Account> accountAll = accountMapper.findAll();
        for(Account account:accountAll){
            System.out.println("查询："+account);
            System.out.println("查询："+account.getUser());
        }
    }

    @Test //执行查询用户，同时查询用户的账号信息方法测试  实现一对多
    public void findUserAndAccountTest(){
        List<User> users = userMapper.findUserAndAccount();
        for(User user:users){
            System.out.println("查询："+user);
            System.out.println("查询："+user.getAccounts());
        }
    }

    @After
    public void destory()throws Exception{
        //6.事务提交
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }
}
