package com.liyun.spring.springbootweb.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebApp 配置
 *
 * @author Li Yun
 * @date 2020/5/4 23:02
 */
@Configuration
//或者实现 WebMvcConfigurer 接口
public class WebAppConfigurer extends WebMvcConfigurationSupport {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 可添加多个
    registry.addInterceptor(new SimpleInterceptor()).addPathPatterns("/**");
  }

}
