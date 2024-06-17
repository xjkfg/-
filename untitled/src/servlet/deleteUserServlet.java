package servlet;

import dao.userDao;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUser.do")
public class deleteUserServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("userChange");
        userDao userdao = new userDao();

        System.out.println("deleteUserServlet");

        if(userdao.deleteByUserName(username))
        {
            List<User> userlist = userdao.queryUserList();
            req.setAttribute("userlist",userlist);
            String deleteSuccess = "deleteSuccess";
            req.setAttribute("deleteSuccess",deleteSuccess);
            // 重定向到删除用户页面
            req.getRequestDispatcher("login/usersManger/userList.jsp").forward(req,resp);
        }
        else{
            // 重定向到登录失败页面
            resp.sendRedirect( "login/loginFill.jsp");
        }
    }
}
