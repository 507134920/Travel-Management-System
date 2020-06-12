package com.lj.trshop.dao;

import com.lj.trshop.entity.Classes;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClassesDao {

    @Test
    public void findAll() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassesDao classesDao = (ClassesDao) applicationContext.getBean("classesDao");

        List<Map<String,Object>> list=  classesDao.findAll();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("list", list);
        System.out.println(map);
    }

}
