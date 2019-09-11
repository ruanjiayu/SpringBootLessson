package com.xian.lessoneight.repository;

import com.xian.lessoneight.base.BaseRepository;
import com.xian.lessoneight.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  9:05
 * @Version: 0.0.1-SHAPSHOT
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

    /**
     * 通过年龄来查询数据。
     * 使用@Query来配置自己定义的SQL，后面的参数nativeQuery = true才是表明使用了原生的sql
     * 如果不配置，默认为false，那么将使用HQL查询方式。
     *
     * @param age
     * @return
     */
    @Query(value = "select * from t_user where t_age > :age", nativeQuery = true)
    List<UserEntity> listAgeMoreThan(@Param("age") Integer age);

    /**
     * 通过名字和年龄来查询数据
     * 如果想要增/删/改操作，需要加上@Modifying才能进行操作
     * 需要加上@Transactional,不然会提示TransactionRequiredException异常，也就是事务异常，当然你也可以在调用这个方法的地方使用@Transactional
     *
     * @param name
     * @param age
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from t_user where t_name = :name and t_age > :age", nativeQuery = true)
    void deleteByNameAndAge(@Param("name") String name, @Param("age") Integer age);
}


