package com.lj.trshop.service;

import java.util.Map;

public interface ShowService {

    Map<String,Object> findColection();
    Map<String,Object> findOrderList();
    Map<String,Object> findChinaPage(String startState,String endState);
    Map<String,Object> findOutsidePage(String startState,String endState);

}
