package io.ollg.store.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Authentication", urlPatterns = "/createNewProduct")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(Boolean.TRUE.equals(req.getSession().getAttribute("authenticated"))){
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect("./login");
        }
    }

    @Override
    public void destroy() {

    }
}
