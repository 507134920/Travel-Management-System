package com.lj.trshop.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lj.trshop.entity.User;
import com.lj.trshop.service.UserService;
import com.lj.trshop.web.JsonResult;
import com.lj.trshop.web.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    private Logger log =
            Logger.getLogger(UserController.class.getSimpleName());

    @RequestMapping("toRegister")
    public String toRegister(){
        //重定向
        return "redirect:register.html";
    }
    /*@RequestMapping("toLogin")
    public String toLogin(){
        return "redirect:login.jsp";
    }*/

   /* @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpServletRequest request,HttpSession session){
        User user = userService.login(username, password);
        //判断用户对象是否为null
        if(user == null){
            //用户名密码或错误
            model.addAttribute("msg","用户名密码或错误");
        }
        //判断用户是否激活
        if(user != null && !"Y".equals(user.getStatus())){
            //用户尚未激活
            model.addAttribute("msg","用户尚未激活");
        }
        //判断登录成功
        if(user != null && "Y".equals(user.getStatus())){
            //将用户对象添加到Session
            //session.setAttribute("USER_SESSION",user);
            request.getSession().setAttribute("user",user);//登录成功标记
            //跳转到主页面
            log.info(user.getUsername());
            return "index.html";
        }
        //返回登录页面
        return "redirect:login.jsp";
    }
    */
    @RequestMapping(value = "/toLogin")
    public String toLoginHtml(){
        return "redirect:logining.html";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpServletRequest request,HttpSession session){
        User user = userService.login(username, password);
        //判断用户对象是否为null
        if(user == null){
            //用户名密码或错误
            model.addAttribute("msg","用户名密码或错误");
        }
        //判断用户是否激活
        if(user != null && !"Y".equals(user.getStatus())){
            //用户尚未激活
            model.addAttribute("msg","用户尚未激活");
        }
        //判断登录成功
        if(user != null && "Y".equals(user.getStatus())){
            //将用户对象添加到Session
            request.getSession().setAttribute("user",user);//登录成功标记
            //跳转到主页面
            return "index.html";
        }
        //返回登录页面
        return "redirect:logining.html";
    }
    /**
     * 查询单个对象
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    /**
     * 退出
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response){
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转主页面
        return "index.html";
    }
    @RequestMapping("/regist")
    @ResponseBody
    public JsonResult register(User user){
        boolean regist = userService.regist(user);
        if(regist){
            return new JsonResult(1,"注册成功");
        }else{
            log.info("失败");
        }
        return new JsonResult(0,"注册失败");
    }
    @RequestMapping("/active")
    public void active(String code, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        if (code != null) {
            //2.调用service完成激活
            boolean flag = userService.active(code);

            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                //msg = "激活成功，<a href='login.jsp'>请登录!</a>";
                msg = "激活成功，<a href='logining.html'>请登录!</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index.html";
    }

    @RequestMapping("/numActive")
    @ResponseBody
    public JsonResult numActive(String code){
        if (code == null || code == ""){
            return new JsonResult(0,"激活码不能为空");
        }else {
            boolean active = userService.active(code);
            if (active){
                return new JsonResult(1,"激活成功");
            }else {
                return new JsonResult(0,"激活失败");
            }
        }
    }
}
