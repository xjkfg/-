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

@WebServlet("/searchNews.do")
public class searchNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsDao newsdao=new newsDao();

        List<News> newsList=newsdao.queryNewsList();
        req.setAttribute("newsList",newsList);
        req.getRequestDispatcher("login/newsManger/newsLan.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsDao newsdao=new newsDao();

        List<News> newsList=newsdao.queryNewsList();
        req.setAttribute("newsList",newsList);
        req.getRequestDispatcher("login/newsManger/newsLan.jsp").forward(req,resp);
    }
}
