package com.xian.lessonnine.controller;

import com.xian.lessonnine.dto.DemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  13:58
 * @Version: 0.0.1-SHAPSHOT
 */
@RestController
public class indexController {

    @Autowired
    private MessageSource messageSource;

    /**
     * http://localhost:8080/validator?name=ruanjiayu&age=1&mail=1005572910@qq.com
     *
     * @param demo 接受到前端传递过来的参数
     * @param result 对参数进行验证后的结果
     * @return
     */
    @RequestMapping(value = "/validator")
    public String validator(@Valid DemoDTO demo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuffer msg = new StringBuffer();
            List<FieldError> fieldErrors = result.getFieldErrors();
            // 获取本地locale.zh_CN
            Locale currentLocale = LocaleContextHolder.getLocale();
            // 遍历错误字段获取错误消息
            for (FieldError fieldError : fieldErrors) {
                //获取错误信息
                String errorMessage = messageSource.getMessage(fieldError, currentLocale);
                //添加到错误消息集合内
                msg.append(fieldError.getField() + "：" + errorMessage + " , ");
            }
            return msg.toString();
        }
        return "验证通过，" + "名称：" + demo.getName() + "年龄：" + demo.getAge() + "邮箱地址：" + demo.getEmail();
    }
}
