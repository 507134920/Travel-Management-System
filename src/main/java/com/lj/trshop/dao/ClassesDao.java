package com.lj.trshop.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClassesDao {
    //查询所有分类信息
    List<Map<String,Object>> findAll();

    //根据分类id 分页查询出旅游产品信息
    List<Map<String,Object>> findObjects(
            @Param("id")Integer id,
            @Param("startIndex")int startIndex,
            @Param("pageSize") int pageSize);

    int getRowCount(@Param("id")Integer id);


    //根据产品名字 旅游产品查看详情
    List<Map<String,Object>> findPageObjects(@Param("name")String name,
                                             @Param("startIndex")int startIndex,
                                             @Param("pageSize") int pageSize);
    int getPageRowCount(@Param("name")String name);
}
