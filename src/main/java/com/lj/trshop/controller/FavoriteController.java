package com.lj.trshop.controller;

import com.lj.trshop.entity.Favorite;
import com.lj.trshop.entity.User;
import com.lj.trshop.service.FavoriteService;
import com.lj.trshop.web.JsonResult;
import com.sun.org.apache.bcel.internal.generic.JSR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.logging.Logger;


@Controller
public class FavoriteController {
    private Logger log =
            Logger.getLogger(FavoriteController.class.getSimpleName());
    @Autowired
    private FavoriteService favoriteService;

    /**
     * 判断是否收藏
     * @param rid
     * @param name
     * @return
     */
    @RequestMapping("/isFavorite")
    @ResponseBody
    public JsonResult isFavorite(Integer rid,String name){
        String m= "undefined";
        if (!name.equals(m)){
            try{
                boolean isfavorite = favoriteService.isFavorite(rid, name);
                if (!isfavorite){
                    return new JsonResult(0,"已收藏过此产品");
                }
                return new JsonResult(rid);
            }catch (Exception e){
                return new JsonResult(0,"系统异常，收藏产品失败，请联系管理员！！");
            }
        }
        return new JsonResult(0,"此用户未登录");
    }

    //增加收藏量
    @RequestMapping("/addCount")
    @ResponseBody
    public JsonResult addCount(Integer rid){
        favoriteService.updateAddCount(rid);
        return new JsonResult(1,"收藏成功");
    }

    /**
     * 去往我的收藏页面
     * @return
     */
    @RequestMapping("/toMyFavorite")
    public String toMyFavorite(){
        return "redirect:myfavorite.html";
    }

    //显示用户收藏
    @RequestMapping("/getFarivote")
    @ResponseBody
    public JsonResult getFarivote(String name){
        String m= "undefined";
        if (!name.equals(m)){
            Map<String, Object> map = favoriteService.findFavorite(name);
            return new JsonResult(map);
        }
        return new JsonResult(0,"用户未登录");
    }

    //取消收藏
    @RequestMapping("/deltFarivote")
    @ResponseBody
    public JsonResult deltFarivote(Integer rid){
        boolean b = favoriteService.deleteFavorite(rid);
        if (b){
            favoriteService.updateCount(rid);
            return new JsonResult(1,"取消成功");
        }
        return new JsonResult(0,"取消失败");
    }
}

