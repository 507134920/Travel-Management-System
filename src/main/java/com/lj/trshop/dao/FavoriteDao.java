package com.lj.trshop.dao;

import com.lj.trshop.entity.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FavoriteDao {
    //判断登录用户是否收藏
    Favorite findByRidAndUid(@Param("rid")Integer rid,@Param("name")String name);
    //为登录用户新增收藏
    Integer insertFavorite(@Param("rid")Integer rid,@Param("name")String name);

    //收藏页显示
    List<Map<String,Object>> findFavorite(@Param("name")String name);
    //取消收藏
    Integer deleteFavorite(@Param("rid")Integer rid);

    //改变收藏量
    void updateAddCount(@Param("rid")Integer rid);
    void updateCount(@Param("rid")Integer rid);
}
