package com.lj.trshop.dao;

import com.lj.trshop.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 通过账户密码查询账户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password")String password);

    /**
     * 注册用户
     */
    User findByUsername(String username);//根据用户名查找数据库是否存在
    void save(User user);//将用户保存进数据库
    Integer findByCode(String code);//根据激活码查找指定用户uid
    void updateStatus(Integer id);//修改激活状态code
    //查询最高收藏量的收藏产品
    //查询最高购买量的收藏产品
}
