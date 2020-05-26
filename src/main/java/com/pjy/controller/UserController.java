package com.pjy.controller;

import com.pjy.pojo.User;
import com.pjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pjy")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private  HttpSession hs;

    /**
     * 用户登录
     * @param uname
     * @param pwd
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/UserLogin")
    public ModelAndView UserLogin(String uname, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ModelAndView mv=new ModelAndView();
        User user = userService.checkLoginDaO(uname, pwd);
        if(user!=null){
            hs=req.getSession();
            hs.setAttribute("user",user);
            mv.setViewName("/main/main");

        }else {
           mv.addObject("rinima","log");
            mv.setViewName("/login");
        }
        return mv;
    }
    /**
     * 用户退出
     */
    @RequestMapping("/UserOut")
    public ModelAndView UserOut( HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView mv=new ModelAndView();
        //获取session对象
         hs=req.getSession();
        //强制销毁sesssion
        hs.invalidate();
        mv.setViewName("/login");
        return mv;
    }
    /**
     * 用户修改密码
     */
    @RequestMapping("/UserChangePwd")
    public void UserChangePwd(String pwd,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User u = (User) req.getSession().getAttribute("user");
        int uid=u.getUid();
        int i = userService.userChangePwdDao(pwd, uid);
        if (i>0){
            //获取Seesion对象
            HttpSession hs=req.getSession();
            hs.setAttribute("rinima","change");
            resp.sendRedirect("/rinima/login.jsp");
        }
    }
    /**
     * 查询所有用户
     */
    @RequestMapping("/findAll")
    public  ModelAndView findAll(Model model,HttpServletRequest req, HttpServletResponse resp){
        ModelAndView mv=new ModelAndView();
        List<User> users = userService.userShowDao();
        if (users!=null){
            model.addAttribute("users",users);
            mv.setViewName("/user/showUser");
        }
        return mv;
    }
    /**
     * 用户注册
     */
    @RequestMapping("/saveUser")
    private void  saveUser(User user,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int i = userService.userRegDao(user);
        if (i> 0) {
            //请求重定向
            hs=req.getSession();
            hs.setAttribute("rinima","reg");
            resp.sendRedirect("/rinima/login.jsp");
            return;
        }
    }
}
