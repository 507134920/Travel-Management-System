package com.lj.trshop.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestShowDao {
    @Test
    public void showDao(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ShowDao showDao = (ShowDao) applicationContext.getBean("showDao");
        List<Map<String,Object>> list= showDao.findColection();
        Map<String,Object> map= new HashMap<>();
        map.put("list",list);
        System.out.println(map);
    }

    @Test
    public void chinaDao(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ShowDao showDao = (ShowDao) applicationContext.getBean("showDao");
        List<Map<String,Object>> list= showDao.findChinaPage("","");
        Map<String,Object> map= new HashMap<>();
        map.put("list",list);
        System.out.println(map);
    }
}
