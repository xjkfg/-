package servlet;

import dao.newsDao;
import dao.userDao;
import user.News;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userDao userdao=new userDao();
        newsDao newsdao=new newsDao();

        System.out.println("login");

        User user = userdao.findByUsername(username,password);
        if(user!=null)
        {
            HttpSession session = request.getSession();
            System.out.println("找到这个人！");
            session.setAttribute("username", username);

            String role=user.getRole();
            String getm="管理员";

            System.out.println(role);
            System.out.println("11111");

            if(getm.equals(role))
            {
                System.out.println("登录的是管理员");
                response.sendRedirect(request.getContextPath()+"/login/loginSuccessManger.jsp");
            }
            else {
                List<News> news=newsdao.queryNewsList();
                request.setAttribute("newsList",news);
                // 重定向到登录成功页面
                response.sendRedirect( request.getContextPath()+"/login/loginSuccess.jsp");
            }
        }
        else{
            System.out.println("22222");
            // 重定向到登录失败页面
            response.sendRedirect( "login/loginFill.jsp");
        }

    }
}
