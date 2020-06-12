package com.lj.trshop.controller;

import com.lj.trshop.service.ShowService;
import com.lj.trshop.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShowController {
    @Autowired
    private ShowService showService;

    @RequestMapping("/showColection")
    @ResponseBody
    public JsonResult showColection(){
        return new JsonResult(showService.findColection());
    }
    @RequestMapping("/findOrderList")
    @ResponseBody
    public JsonResult showOrderList(){
        return new JsonResult(showService.findOrderList());
    }

    /**
     * 国内
     * @return
     */
    @RequestMapping("/findChinaPage")
    @ResponseBody
    public JsonResult chinaPage(String startState, String endState){
        return new JsonResult(showService.findChinaPage(startState,endState));
    }
    /**
     * 国外
     * @return
     */
    @RequestMapping("/findOutsidePage")
    @ResponseBody
    public JsonResult outsidePage(String startState, String endState){
        return new JsonResult(showService.findOutsidePage(startState,endState));
    }

}
