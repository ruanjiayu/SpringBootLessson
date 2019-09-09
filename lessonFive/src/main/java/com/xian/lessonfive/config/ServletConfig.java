package com.xian.lessonfive.config;

import com.xian.lessonfive.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  9:54
 * @Version: 0.0.1-SHAPSHOT
 */
@Configuration
public class ServletConfig {

    /**
     * 使用Bean注册Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new TestServlet(), "/test");
    }
}
