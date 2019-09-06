package com.xian.lessonthree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/6  13:48
 * @Version: 0.0.1-SHAPSHOT
 */
@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping(value = "/loginView", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "index";
    }

}
