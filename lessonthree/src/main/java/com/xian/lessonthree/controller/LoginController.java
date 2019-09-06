package com.xian.lessonthree.controller;

import com.xian.lessonthree.DO.UserDO;
import com.xian.lessonthree.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/6  11:03
 * @Version: 0.0.1-SHAPSHOT
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/login")
    public String login(UserDO userDO, HttpServletRequest request) {
        UserDO user = userJPA.findByNameAndPwd(userDO.getName(), userDO.getPwd());
        if (ObjectUtils.isEmpty(user)) {
            return "不存在该用户";
        } else {
            // 将用户写入session
            request.getSession().setAttribute("session_user", userDO);
            return "成功登录";
        }
    }
}
