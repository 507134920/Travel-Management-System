package com.lj.trshop.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShowDao {
    List<Map<String,Object>> findColection();
    List<Map<String,Object>> findOrderList();
    List<Map<String,Object>> findChinaPage(@Param("startState") String startState,
                                           @Param("endState") String endState);
    List<Map<String,Object>> findOutsidePage(@Param("startState") String startState,
                                           @Param("endState") String endState);
}
