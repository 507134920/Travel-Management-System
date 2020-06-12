package com.lj.trshop.dao;

import com.lj.trshop.entity.User;
import com.lj.trshop.util.MailUtils;
import com.lj.trshop.util.UuidUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestUserDao {

    @Test
    public void login(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = userDao.findByUsernameAndPassword("zhangsan", "12345678");
        System.out.println(user);
    }
    @Test
    public void regist(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = userDao.findByUsername("zhangsan");
        System.out.println(user);

        User user1 = new User();
        user1.setUsername("zhangsanfen");
        user1.setPassword("12345678");
        user1.setName("张三丰");
        user1.setBirthday(new Date());
        user1.setEmail("1426331637@qq.com");
        User u = userDao.findByUsername(user1.getUsername());
        if(u != null){
            //用户名存在，注册失败
            System.out.println("用户名存在，注册失败");
            System.out.println(user1);
        }else {
            //2.保存用户信息
            //2.1设置激活码，唯一字符串
            user1.setCode(UuidUtil.getUuid());
            //2.2设置激活状态
            user1.setStatus("N");
            System.out.println(user1);
            userDao.save(user1);

            //3.激活邮件发送，邮件正文？
            String content = "<a href='http://localhost:8080/tshop/user/active?code=" + user.getCode() + "'>点击激活【HN旅游网】</a>";

            MailUtils.sendMail(user.getEmail(), content, "激活邮件");
            System.out.println("注册成功");
        }
    }

    /**
     * 激活
     */
    @Test
    public void active(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        int byCode = userDao.findByCode("3d5893c0884d49819064f0e34dcf1b96");
        System.out.println(byCode);
        if (!"".equals("byCode")) {
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(byCode);
            System.out.println("激活成功");
        } else {
            System.out.println("激活失败");
        }
    }

}
