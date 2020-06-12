package com.lj.trshop.service.impl;

import com.lj.trshop.dao.UserDao;
import com.lj.trshop.entity.User;
import com.lj.trshop.service.UserService;
import com.lj.trshop.util.MailUtils;
import com.lj.trshop.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }

    /**
     * 注册
     * @param user
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null

        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //3.激活邮件发送，邮件正文？
        String content="<a href='http://localhost:8080/trshop/active?code="+user.getCode()+"'>点击激活【HN旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        String content1="激活码为："+user.getCode();
        MailUtils.sendMail(user.getEmail(),content1,"旅游网注册激活码");
        return true;
    }

    /**
     * 激活
     * @param code
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        try {
            int uid = userDao.findByCode(code);
            if (uid >0) {
                //2.调用dao的修改激活状态的方法
                userDao.updateStatus(uid);
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
