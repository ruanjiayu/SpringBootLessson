package com.xian.lessonthree.jpa;

import com.xian.lessonthree.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Description: JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）
 * @Author: Xian
 * @CreateDate: 2019/9/5  18:36
 * @Version: 0.0.1-SHAPSHOT
 */
@Repository
public interface UserJPA extends JpaRepository<UserDO, Long>, JpaSpecificationExecutor<UserJPA>, Serializable {

    /**
     * 查询用户通过用户名和密码
     * @param name
     * @param pwd
     * @return
     */
    UserDO findByNameAndPwd(String name, String pwd);
}
