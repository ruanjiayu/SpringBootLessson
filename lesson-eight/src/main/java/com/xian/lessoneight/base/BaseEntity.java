package com.xian.lessoneight.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  10:33
 * @Version: 0.0.1-SHAPSHOT
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5679670463752520861L;
    /** 分页，默认页码*/
    protected int page = 1;
    /** 分页，默认每页条数*/
    protected int size = 20;
    /** 分页, 排序列的名称*/
    protected String sidx = "id";
    /** 排序的规则*/
    protected String sort = "asc";
}
