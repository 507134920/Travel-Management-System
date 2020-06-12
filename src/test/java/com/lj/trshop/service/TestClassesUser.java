package com.lj.trshop.service;

import com.lj.trshop.BaseTest;
import com.lj.trshop.entity.Classes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TestClassesUser extends BaseTest {
    @Autowired
    private ClassesService classesService;

    @Test
    public void findAll(){
        Map<String,Object> map = classesService.findAll();
        System.out.println(map);
    }

    @Test
    public void findObjects(){
        Map<String,Object> map = classesService.findObjects(2,1);
        System.out.println(map);
    }
    @Test
    public void findPageobjcts(){
        Map<String,Object> map = classesService.findPageObjects("张家界",1);
        System.out.println(map);
    }
}
