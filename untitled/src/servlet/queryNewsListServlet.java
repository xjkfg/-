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

@WebServlet("/queryNewsList.do")
public class queryNewsListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String queryNews=req.getParameter("queryNews");
        newsDao newsdao=new newsDao();

        System.out.println("queryNewsList");
        System.out.println();

        if(queryNews!="")
        {
            System.out.println("根据作者进行精准查询");
            List<News> newsList=newsdao.queryNewsList(queryNews);
            if(newsList!=null)
            {

                System.out.println("搜到新闻列表");
                req.setAttribute("newsList",newsList);
               /* if("1".equals(newsChange))
                {
                    req.getRequestDispatcher("login/newsManger/newsDelete.jsp").forward(req,resp);
                }
                else if("2".equals(newsChange))
                {
                    req.getRequestDispatcher("login/newsManger/newsUpdate.jsp").forward(req,resp);
                }
                else {*/
                    req.getRequestDispatcher("login/newsManger/newsList.jsp").forward(req,resp);
               //}

            }
            else{
                resp.sendRedirect( "login/loginFill.jsp");
            }
        }
        else{
            System.out.println("查询所有新闻列表");
            List<News> newsList=newsdao.queryNewsList();
            if(newsList!=null)
            {
                String newsChange=req.getParameter("newsChange");
                System.out.println("搜到新闻列表");
                req.setAttribute("newsList",newsList);
               /* if("1".equals(newsChange))
                {
                    req.getRequestDispatcher("login/newsManger/newsDelete.jsp").forward(req,resp);
                }
                else if("2".equals(newsChange))
                {
                    req.getRequestDispatcher("login/newsManger/newsUpdate.jsp").forward(req,resp);
                }
                else {*/
                if("4".equals(newsChange))
                {
                    req.getRequestDispatcher("login/newsManger/newsLan.jsp").forward(req,resp);
                }
                else{
                    req.getRequestDispatcher("login/newsManger/newsList.jsp").forward(req,resp);
                }

                //}
            }
            else{
                resp.sendRedirect( "login/loginFill.jsp");
            }
        }
    }
}
