package com.xian.lessonfour.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  9:34
 * @Version: 0.0.1-SHAPSHOT
 */
@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {

    /**
     * 自己定义静态资源路径问题
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ruanjiayu/fourth/resources/**").addResourceLocations("classpath:/static/");
    }
}
