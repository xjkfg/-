package filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login/*")
public class loginFillter extends HttpFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化....");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request.getSession().getAttribute("username")!=null)
        {
            chain.doFilter(request,response);
        }
        else{
            response.sendError(403);
            //response.sendRedirect( "admin/login.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了....");
    }
}
