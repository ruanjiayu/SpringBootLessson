package com.xian.lessonseven.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  13:16
 * @Version: 0.0.1-SHAPSHOT
 */
@RestController
@Slf4j
public class IndexController {

    @GetMapping("index")
    public String index(){
        log.debug("【我是debug");
        log.info("【我是info】");
        log.warn("【我是warning】");
        log.error("【我是error】");
        return "访问Index";
    }

}
