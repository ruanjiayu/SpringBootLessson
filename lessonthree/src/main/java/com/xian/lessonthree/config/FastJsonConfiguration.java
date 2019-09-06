package com.xian.lessonthree.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/6  10:05
 * @Version: 0.0.1-SHAPSHOT
 */
@Configuration
public class FastJsonConfiguration {

    @Bean
    public HttpMessageConverters getFastJSONHttpMessageConvert() {
        // 定义一个转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
// 添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
// 将返回值为null的字符串转变成"",在这里可以自己设置
                SerializerFeature.WriteNullStringAsEmpty
        );
        // 处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

// 在转换器中添加配置信息
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }



}
