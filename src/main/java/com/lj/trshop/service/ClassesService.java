package com.lj.trshop.service;

import java.util.Map;

public interface ClassesService {
    //查询所有分类信息
    Map<String,Object> findAll();

    //根据分类id 分页查询
    Map<String,Object> findObjects(Integer id,int pageCurrent);

    //根据产品名字 旅游产品查看详情
    Map<String,Object> findPageObjects(String name,int pageCurrent);
}
