package com.lj.trshop.service.impl;

import com.lj.trshop.dao.ShowDao;
import com.lj.trshop.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowDao showDao;

    @Override
    public Map<String, Object> findColection() {
        List<Map<String, Object>> colection = showDao.findColection();
        Map<String,Object> map= new HashMap<>();
        map.put("list", colection);
        return map;
    }

    @Override
    public Map<String, Object> findOrderList() {
        List<Map<String, Object>> orderList = showDao.findOrderList();
        Map<String,Object> map= new HashMap<>();
        map.put("list", orderList);
        return map;
    }

    @Override
    public Map<String, Object> findChinaPage(String startState, String endState) {
        List<Map<String, Object>> chinaPage = showDao.findChinaPage(startState,endState);
        Map<String,Object> map= new HashMap<>();
        map.put("list", chinaPage);
        return map;
    }

    @Override
    public Map<String, Object> findOutsidePage(String startState, String endState) {
        List<Map<String, Object>> outsidePage = showDao.findOutsidePage(startState,endState);
        Map<String,Object> map= new HashMap<>();
        map.put("list", outsidePage);
        return map;
    }

}
