package com.lj.trshop.controller;


import com.lj.trshop.entity.Classes;
import com.lj.trshop.service.ClassesService;
import com.lj.trshop.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ClassController {
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/findAll")
    @ResponseBody
    public JsonResult findAll(){
        Map<String,Object> map = classesService.findAll();
        return new JsonResult(map);
    }

    //分页查询
    @RequestMapping("/findObjects")
    @ResponseBody
    public JsonResult findObjects(Integer id, Integer pageCurrent){
        Map<String,Object> map = classesService.findObjects(id,pageCurrent);
        return new JsonResult(map);
    }

    //根据产品名字 分页查询产品详情
    @RequestMapping("/findPageObjects")
    @ResponseBody
    public JsonResult findPageObjects(String name, Integer pageCurrent){
        Map<String,Object> map = classesService.findPageObjects(name,pageCurrent);
        return new JsonResult(map);
    }
}
