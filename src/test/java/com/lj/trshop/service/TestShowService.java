package com.lj.trshop.service;

import com.lj.trshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TestShowService extends BaseTest {
    @Autowired
    private ShowService showService;

    @Test
    public void num(){
        Map<String, Object> colection = showService.findColection();
        System.out.println(colection);
    }

    @Test
    public void order(){
        Map<String, Object> colection = showService.findChinaPage("","");
        System.out.println(colection);
    }

}
