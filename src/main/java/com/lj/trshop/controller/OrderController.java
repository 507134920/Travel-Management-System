package com.lj.trshop.controller;

import com.lj.trshop.service.BuyService;
import com.lj.trshop.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.logging.Logger;

@Controller
public class OrderController {
    @Autowired
    private BuyService buyService;

    //购买
    @RequestMapping("/doBuyOrder")
    @ResponseBody
    public JsonResult doBuyOrder(Integer rid){
        Map<String,Object> map=buyService.buyOrder(rid);
        return new JsonResult(map);
    }

    //查询库存
    @RequestMapping("/doFindNum")
    @ResponseBody
    public JsonResult doFindNum(Integer rid){
        int num =buyService.findNum(rid);
        return new JsonResult(num);
    }

    //新增订单
    @RequestMapping("/insertOrder")
    @ResponseBody
    public JsonResult doInsertOrder(Integer rid, Integer num, float money, String name){
        /*log.info("rid="+rid);
        log.info("num="+num);
        log.info("money="+money);
        log.info("name="+name);*/
        String m= "undefined";
        if (!name.equals(m)){
            try {
                buyService.insertOrder(rid, num, money, name);
                return new JsonResult();
            }catch (Exception e){
                return new JsonResult(0,"系统异常，订单创建异常，请联系管理员！！");
            }

        }
        return new JsonResult(0,"用户未登录");
    }
    @RequestMapping("/toMyCar")
    public String toMyCar(){
        return "redirect:myCar.html";
    }

    //购物车内显示未支付订单
    @RequestMapping("/findCar")
    @ResponseBody
    public JsonResult findCar(String name){
        String m= "undefined";
        if (!name.equals(m)){
            Map<String, Object> map = buyService.findCar(name);
            return new JsonResult(map);
        }
        return new JsonResult(0,"用户未登录");
    }

    //购物车内取消未支付订单
    @RequestMapping("/dleteCar")
    @ResponseBody
    public JsonResult dleteCar(Integer id){
        boolean b = buyService.dleteCar(id);
        if (b){
            return new JsonResult(1,"取消订单成功");
        }
        return new JsonResult(0,"取消订单失败");
    }
    //购物车内支付订单
    @RequestMapping("/buyOrder")
    @ResponseBody
    public JsonResult buyOrder(Integer id){
        //1、完成支付、修改产品状态
        boolean b1 = buyService.updateStates(id);
        //2、修改库存
        boolean b2 = buyService.updateNum(id);
        if (b1&& b2) {
            return new JsonResult(1,"所购产品状态修改成功");
        }
        return new JsonResult(0,"所购产品状态修改失败");
    }

}
