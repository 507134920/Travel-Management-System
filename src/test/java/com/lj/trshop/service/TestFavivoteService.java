package com.lj.trshop.service;

import com.lj.trshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestFavivoteService extends BaseTest {
    @Autowired
    private FavoriteService favoriteService;

    @Test
    public void isFavorite(){
        boolean favorite = favoriteService.isFavorite(4, "张三");
        System.out.println(favorite);
    }
}
