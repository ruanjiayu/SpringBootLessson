package com.xian.lessoneight.repository;

import com.xian.lessoneight.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  9:11
 * @Version: 0.0.1-SHAPSHOT
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void listAll() {
        userRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void save() {
        UserEntity user = new UserEntity("ruanjiayu", 25, "余杭", "123456");
        System.out.println(userRepository.save(user));
    }

    @Test
    public void update() {
        UserEntity user = new UserEntity(2L, "ruanjiayu", 25, "余杭", "余杭");
        System.out.println(userRepository.save(user));
    }

    @Test
    public void delete() {
        userRepository.deleteById(11L);
    }

    @Test
    public void listByAge() {
        userRepository.listAgeMoreThan(24).stream().forEach(System.out::println);
    }

    @Test
    public void deleteByNameAndAge() {
        userRepository.deleteByNameAndAge("jing", 23);
    }

    @Test
    public void findAll() {
        UserEntity user = new UserEntity();
        user.setSize(3);
        user.setPage(1);
        user.setSort("desc");
        // 获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equals(user.getSort()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        // 设置排序
        Sort sort = new Sort(sort_direction, user.getSidx());
        Pageable pageable = PageRequest.of( user.getPage() - 1,user.getSize(), sort);
        userRepository.findAll(pageable).stream().forEach(System.out::println);
    }
}