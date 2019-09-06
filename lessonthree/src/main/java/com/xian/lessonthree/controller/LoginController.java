package com.xian.lessonthree.controller;

import com.alibaba.fastjson.JSONObject;
import com.xian.lessonthree.DO.UserDO;
import com.xian.lessonthree.jpa.UserJPA;
import com.xian.lessonthree.utils.LoggerUtils;
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
    public JSONObject login( HttpServletRequest request, UserDO userDO) {
        UserDO user = userJPA.findByNameAndPwd(userDO.getName(), userDO.getPwd());
        JSONObject jsonObject = new JSONObject();
        if (ObjectUtils.isEmpty(user)) {
            jsonObject.put("msg",String.format("登录失败", userDO.getName()));
        } else {
            // 将用户写入session
            request.getSession().setAttribute("session_user", userDO);
            jsonObject.put("msg",String.format("用户:%s~~登录成功", userDO.getName()));
        }
        request.setAttribute(LoggerUtils.LOGGER_RETURN,jsonObject);
        return jsonObject;
    }
}
