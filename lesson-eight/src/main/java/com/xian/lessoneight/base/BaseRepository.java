package com.xian.lessoneight.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  10:26
 * @Version: 0.0.1-SHAPSHOT
 */
@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {
}
