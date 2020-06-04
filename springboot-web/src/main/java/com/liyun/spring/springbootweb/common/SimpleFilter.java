package com.liyun.spring.springbootweb.common;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 一个简单的 Filter 示例
 *
 * @author Li Yun
 * @date 2020/5/5 9:11
 */
@Component
public class SimpleFilter implements Filter {

  /**
   * 实例化 Filter 后运行 init。
   * 注意：服务完全启动前执行 init 方法，此时还没收到任何请求
   * @param filterConfig
   * @throws ServletException
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Filter：实例化 Filter 后运行 init");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    System.out.println("Filter：执行过滤动作");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("Filter：销毁");
  }
}
