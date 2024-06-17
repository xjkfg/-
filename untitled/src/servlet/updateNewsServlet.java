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

@WebServlet("/updateNews.do")
public class updateNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行数据回显
        req.setCharacterEncoding("UTF-8");
        String newsManger=req.getParameter("newsManger");
        //进行新闻操作
        newsDao newsdao = new newsDao();

        List<News> news = newsdao.queryNewsList(newsManger);

        if(news == null)
        {
            resp.sendError(500,"没有这个新闻");
        }
        else{
            String searchNews=req.getParameter("searchNews");
            req.setAttribute("news",news);
            System.out.println(searchNews);
            if("4".equals(searchNews))
            {
                req.getRequestDispatcher("login/newsManger/newsLans.jsp").forward(req,resp);
            }
            else{
                //用户数据回显
                System.out.println("即将进行页面跳转");
                req.getRequestDispatcher("login/newsManger/newsUpdates.jsp").forward(req,resp);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title=req.getParameter("title");
        String author=req.getParameter("author");
        String state=req.getParameter("state");
        String category=req.getParameter("category");
        String content=req.getParameter("content");

        newsDao newsdao = new newsDao();
        boolean r = newsdao.updateNews(title,author,state,category,content,title);


        if(r)
        {
            List<News> newsList=newsdao.queryNewsList();
            req.setAttribute("newsList",newsList);
            String updateNewsSuccess = "updateSuccess";
            req.setAttribute("updateSuccess",updateNewsSuccess);
            req.getRequestDispatcher("login/newsManger/newsList.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect( "login/loginFill.jsp");
        }
    }
}
