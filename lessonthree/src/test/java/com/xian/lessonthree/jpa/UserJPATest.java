package com.xian.lessonthree.jpa;

import com.xian.lessonthree.DO.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/6  11:11
 * @Version: 0.0.1-SHAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserJPATest {

    @Autowired
    private UserJPA userJPA;

    @Test
    public void findByNameAndPwd() {
        log.info(userJPA.findByNameAndPwd("1", "123456").toString());
    }
}