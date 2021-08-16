package com.zuoshao.vote.config;

/**
 * @author zuoshao
 * @date 2019/6/18 - 16:22
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 资源映射路径
 */
@Configuration
class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/IDEAworkspace/vote/src/main/resources/static/image");
    }
}

