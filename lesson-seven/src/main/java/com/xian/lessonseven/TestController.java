package com.xian.lessonseven;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  13:20
 * @Version: 0.0.1-SHAPSHOT
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("test")
    public String test(){
        log.debug("【我是test-debug】");
        log.info("【我是test-info】");
        log.warn("【我是test-warning】");
        log.error("【我是test-error】");
        return "访问Test";
    }

}
