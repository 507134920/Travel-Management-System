package com.lj.trshop.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBuyDao {
    @Test
    public void buyOrder(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        BuyDao buyDao = (BuyDao) applicationContext.getBean("buyDao");
        List<Map<String,Object>> list= buyDao.buyOrder(4);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("list",list);
        System.out.println(map);
    }
}
