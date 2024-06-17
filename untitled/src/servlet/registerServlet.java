package servlet;

import dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/register.do")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//读取中文信息时不会出错。
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String profession = req.getParameter("profession");
        String favor = req.getParameter("favor");
        String description=req.getParameter("description");

        String role = "一般用户";
        String status = "可用";

        System.out.println("registerServlet");

        userDao userdao=new userDao();
        if(userdao.insertUser(username,password,gender,profession,favor,description,role,status))
        {
            // 重定向到登录成功页面
            response.sendRedirect( "admin/login.jsp");
        }
        else {
            // 重定向到登录失败页面
            response.sendRedirect( "login/loginFill.jsp");
        }
    }
}
