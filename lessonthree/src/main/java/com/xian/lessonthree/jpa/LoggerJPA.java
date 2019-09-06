package com.xian.lessonthree.jpa;

import com.xian.lessonthree.DO.LoggerDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/6  15:57
 * @Version: 0.0.1-SHAPSHOT
 */
public interface LoggerJPA extends JpaRepository<LoggerDO, Long> {
}
