package servlet;


import dao.newsDao;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/AddNews.do")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName=req.getParameter("coverUrl");
        String path="D:\\java\\semster\\Classsprice\\untitled\\web\\img\\";
        path+=fileName;

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String title=req.getParameter("title");
        String author=req.getParameter("author");
        String state=req.getParameter("state");
        String category=req.getParameter("category");
        String content=req.getParameter("content");
        int viewCount=0;

        //文件表单的获取方式
        Part filename=req.getPart("coverUrl");
        String coverUrl=filename.getSubmittedFileName();
        String path="D:\\java\\semster\\Classsprice\\untitled\\web\\img\\";
        path+=coverUrl;
        filename.write(path);

        System.out.println("AddNewsServlet");
        System.out.println(filename);

        newsDao newsdao=new newsDao();
        boolean r = newsdao.insertNews(title,author,state,category,coverUrl,content,viewCount);
        System.out.println(r);

        if(r)
        {
            String addNewsSuccess="addNewsSuccess";
            System.out.println("新闻插入成功");
            req.setAttribute("addNewsSuccess",addNewsSuccess);
            req.getRequestDispatcher("login/newsManger/newsRelease.jsp").forward(req, resp);
        }
        else{
            System.out.println("新闻插入失败");
            // 重定向到失败页面
            resp.sendRedirect( "login/loginFill.jsp");
        }
    }
}
