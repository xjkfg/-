package servlet;

import dao.newsDao;
import user.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteNews.do")
public class deleteNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String newsManger=req.getParameter("newsManger");
        newsDao newsdao = new newsDao();
        //判断删除用户是否成功
        boolean r=newsdao.deleteNews(newsManger);
        if(r)
        {
            List<News> newsList=newsdao.queryNewsList();
            req.setAttribute("newsList",newsList);
            String deleteNewsSuccess="deleteNewsSuccess";
            req.setAttribute("deleteNewsSuccess",deleteNewsSuccess);
            //删除成功，就返回删除用户页面
            req.getRequestDispatcher("login/newsManger/newsList.jsp").forward(req,resp);
        }
        else{
            // 重定向到登录失败页面
            resp.sendRedirect( "login/loginFill.jsp");
        }
    }
}
