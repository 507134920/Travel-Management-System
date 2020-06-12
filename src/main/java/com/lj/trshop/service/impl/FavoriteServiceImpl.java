package com.lj.trshop.service.impl;

import com.lj.trshop.dao.FavoriteDao;
import com.lj.trshop.entity.Favorite;
import com.lj.trshop.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteDao favoriteDao;

    //收藏
    @Override
    public boolean isFavorite(Integer rid,String name) {
        //1、先判断此用户是否已收藏该产品
        Favorite byRidAndUid = favoriteDao.findByRidAndUid(rid,name);
        if (byRidAndUid==null){
            //2、未收藏的用户进行收藏操作
            int insertFavorite = favoriteDao.insertFavorite(rid,name);
            if(insertFavorite>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    //收藏页显示
    @Override
    public Map<String, Object> findFavorite(String name) {
        List<Map<String,Object>> list= favoriteDao.findFavorite(name);
        Map<String,Object> map= new HashMap<>();
        map.put("list",list);
        return map;
    }
    //取消收藏
    @Override
    public boolean deleteFavorite(Integer rid) {
        Integer delete = favoriteDao.deleteFavorite(rid);
        if(delete>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void updateAddCount(Integer rid) {
        favoriteDao.updateAddCount(rid);
    }

    @Override
    public void updateCount(Integer rid) {
        favoriteDao.updateCount(rid);
    }
}
