package com.wak.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wak
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取session中的user信息，判断用户是否已经登录
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //获取请求路径
        String uri = req.getRequestURI();

        //配置拦截路径
        String[] urls = {"/login", "/login.html", "/register", "register.html", "/js", "/element-ui"};
        for (String url : urls) {
            if (url.equals(uri)) {
                //当和uri相同时，就放行，并且直接结束不再执行后续的，只有当url不是登录时才拦截，判断是否登录
                chain.doFilter(request, response);
                return;
            }
        }

        if (user == null) {
            //未登录就跳转到登录页面
            req.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            //已登录就放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
