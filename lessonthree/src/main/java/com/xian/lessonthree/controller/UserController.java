package com.xian.lessonthree.controller;

import com.xian.lessonthree.DO.UserDO;
import com.xian.lessonthree.jpa.UserJPA;
import com.xian.lessonthree.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/5  17:25
 * @Version: 0.0.1-SHAPSHOT
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<UserDO> list( HttpServletRequest request) {
        List<UserDO> userDOList = userJPA.findAll();
        request.setAttribute(LoggerUtils.LOGGER_RETURN, userDOList);
        return userDOList;
    }

    @RequestMapping(value = "/save")
    public UserDO save(UserDO userDO) {
        return userJPA.save(userDO);
    }

    @RequestMapping(value = "delete")
    public List<UserDO> delete(long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
