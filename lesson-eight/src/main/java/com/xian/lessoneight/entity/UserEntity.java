package com.xian.lessoneight.entity;

import com.xian.lessoneight.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  9:01
 * @Version: 0.0.1-SHAPSHOT
 */
@Entity
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity  extends BaseEntity {

    @Id
    /** 主键自动生成,很重要*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    @Column(name = "t_pwd")
    private String pwd;

    public UserEntity(String name, int age, String address, String pwd) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.pwd = pwd;
    }
}
