package com.lj.trshop.service;

import com.lj.trshop.BaseTest;
import com.lj.trshop.dao.UserDao;
import com.lj.trshop.entity.User;
import com.lj.trshop.web.ResultInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserService extends BaseTest {
    @Autowired
    private UserService userService;
    private UserDao userDao;
    @Test
    public void login(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("12345678");
        User user1 = userService.login(user.getUsername(), user.getPassword());
        //判断用户对象是否为null
        if(user1 == null){
            //用户名密码或错误
            System.out.println("用户名密码或错误");
        }
        //判断用户是否激活
        if(user1 != null && !"Y".equals(user1.getStatus())){
            //用户尚未激活
            System.out.println("用户尚未激活");
        }
        //判断登录成功
        if(user1 != null && "Y".equals(user1.getStatus())){
            //将用户对象添加到Session
            System.out.println(user1.getName()+"登录成功");
        }
    }

    /**
     * 注册
     */
    @Test
    public void regist(){
        User user1 = new User();
        user1.setUsername("zhangsanfen");
        user1.setPassword("12345678");
        user1.setName("张三丰");
        user1.setEmail("1426331637@qq.com");

        boolean regist = userService.regist(user1);
        if(regist){
            System.out.println("执行");
        }else {
            System.out.println("出错");
        }
    }

    /**
     * 激活
     */
    @Test
    public void active(){
        ResultInfo info = new ResultInfo();
        String code="bfb4ba0c4191486f8d6e3451ad0ae639";
        if (code != null) {
            //2.调用service完成激活
            boolean flag = userService.active(code);

            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功，<a href='login.jsp'>请登录!</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }

        }
    }
}
