package com.xian.lessonthree.DO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 日志表
 * @Author: Xian
 * @CreateDate: 2019/9/6  15:50
 * @Version: 0.0.1-SHAPSHOT
 */

@Data
@Entity
@Table(name = "t_logger_infos")
@org.hibernate.annotations.Table(appliesTo = "t_logger_infos",comment="日志操作信息")
public class LoggerDO implements Serializable {


    private static final long serialVersionUID = 5067724381250999576L;
    @Id
    /** 设置为自增的关键 */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) COMMENT '编号'")
    private Long id;

    @Column(name = "client_ip", columnDefinition = "varchar(32) COMMENT '客户端请求IP'")
    private String clientIp;

    @Column(name = "url", columnDefinition = "varchar(32) COMMENT 'url'")
    private String url;

    @Column(name = "type", columnDefinition = "varchar(32) COMMENT '终端请求方式:普通请求 ajax请求'")
    private String type;

    @Column(name = "method", columnDefinition = "varchar(32) COMMENT '请求的方法:GET POST PUT DELETE'")
    private String method;

    @Column(name = "param_data", columnDefinition = "varchar(128) COMMENT '请求参数内容'")
    private String paramData;

    @Column(name = "session_id", columnDefinition = "varchar(128) COMMENT '请求接口的唯一session标识'")
    private String sessionId;

    @Column(name = "time", columnDefinition = "timestamp COMMENT '请求时间'")
    private Timestamp time;

    @Column(name = "return_time", columnDefinition = "varchar(32) COMMENT '接口返回时间'")
    private String returnTime;

    @Column(name = "return_data", columnDefinition = "varchar(1024) COMMENT '返回的数据'")
    private String returnData;

    @Column(name = "http_status_code", columnDefinition = "varchar(32) COMMENT '返回的http状态码'")
    private String httpStatusCode;

    @Column(name = "time_consuming", columnDefinition = "int(11) COMMENT '请求消耗的时间'")
    private Integer timeConsuming;

}
