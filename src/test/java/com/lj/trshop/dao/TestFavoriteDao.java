package com.lj.trshop.dao;

import com.lj.trshop.entity.Favorite;
import com.lj.trshop.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFavoriteDao {

    @Test
    public void login(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        FavoriteDao favoriteDao = (FavoriteDao)applicationContext.getBean("favoriteDao");
        //Favorite byRidAndUid = favoriteDao.findByRidAndUid(4, "张三");
        Integer insertFavorite = favoriteDao.insertFavorite(4, "张三");
        //System.out.println(byRidAndUid);
        System.out.println(insertFavorite);
    }
}
