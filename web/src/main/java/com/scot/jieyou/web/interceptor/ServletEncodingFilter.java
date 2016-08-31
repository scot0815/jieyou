package com.scot.jieyou.web.interceptor;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by scot on 2016/8/3.
 */
public class ServletEncodingFilter implements Filter {

    private String encoding;
    @Override
    // 应用程序启动前有容器调用
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
// 对于每个URL映射到该过滤器的请求，由容器调用该方法

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if(encoding!=null){
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setContentType("text/html;charset="+encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
//void destroy()在应用程序关闭时，由容器调用。
    public void destroy() {
        encoding= null;
    }
}
