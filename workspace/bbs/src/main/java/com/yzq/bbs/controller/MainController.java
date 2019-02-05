package com.yzq.bbs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzq.bbs.pojo.Tab;
import com.yzq.bbs.serviceImpl.ReplyServiceImpl;
import com.yzq.bbs.serviceImpl.TabServiceImpl;
import com.yzq.bbs.serviceImpl.TopicServiceImpl;
import com.yzq.bbs.serviceImpl.UserServiceImpl;

/**
 * 主控制类
 */
@Controller
public class MainController {

    @Autowired
    public TopicServiceImpl topicService;
    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TabServiceImpl tabService;

    /**
     * 进入登录页面.
     */
    @RequestMapping(value = {"/signin"})
    public ModelAndView signin(){
        ModelAndView signinPage=new ModelAndView("signin");

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signinPage.addObject("topicsNum",topicsNum);
        signinPage.addObject("usersNum",usersNum);
        return  signinPage;
    }

    /**
     * 进入注册页面.
     */
    @RequestMapping("/signup")
    public ModelAndView signup(){
        ModelAndView signupPage=new ModelAndView("signup");

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signupPage.addObject("topicsNum",topicsNum);
        signupPage.addObject("usersNum",usersNum);
        return  signupPage;
    }

    /**
     * 进入新建主题页面
     */
    @RequestMapping(value = {"/new"})
    public ModelAndView newTopic(){
        ModelAndView newTopicPage=new ModelAndView("new");
        List<Tab> tabs=tabService.getAllTabs();

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        newTopicPage.addObject("tabs",tabs);
        newTopicPage.addObject("topicsNum",topicsNum);
        newTopicPage.addObject("usersNum",usersNum);
        return  newTopicPage;
    }

    /**
     * 配置404页面
     */
    @RequestMapping("*")
    public String notFind(){
        return "404";
    }
}
