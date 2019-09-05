package com.xian.lessonthree.DO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/5  17:28
 * @Version: 0.0.1-SHAPSHOT
 */
@Entity
@Table(name = "t_user")
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 3882601713927827616L;
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
}
