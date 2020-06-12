package com.lj.trshop.service;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface FavoriteService {
    boolean isFavorite(Integer rid,String name);
    //收藏页显示
    Map<String,Object> findFavorite(String name);
    //取消收藏
    boolean deleteFavorite(Integer rid);
    //改变收藏量
    void updateAddCount(Integer rid);
    void updateCount(Integer rid);
}
