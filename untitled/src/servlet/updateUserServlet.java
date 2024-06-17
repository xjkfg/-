package servlet;

import dao.userDao;
import user.News;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateUser.do")
public class updateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行数据会显
        req.setCharacterEncoding("UTF-8");
        String userChange=req.getParameter("userChange");
        userDao userdao = new userDao();

        System.out.println(userChange);

        System.out.println("doGet");
        List<User> users = userdao.queryUserList(userChange);

        for(User list:users)
        {
            System.out.println(list.getUsername()+" "+list.getPassword()+" "+list.getGender()+" "+list.getProfession()+" "+list.getRole());
        }

        if(users == null)
        {
            resp.sendError(500,"查无此人");
        }
        else{
            req.setAttribute("userlist",users);
            //用户数据回显
            System.out.println("即将进行页面跳转");
            req.getRequestDispatcher("login/usersManger/usersUpdate.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取表单的值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String profession = req.getParameter("profession");
        String favor = req.getParameter("favor");
        String description=req.getParameter("description");
        String role = req.getParameter("role");
        String status=req.getParameter("status");

        userDao userdao = new userDao();

        System.out.println("updateUserServlet");

        boolean r = userdao.updateUser(username,password,gender,profession,favor,description,role,status,username);
        //判断是否修改成功
        if(r)
        {
            List<User>  userlist = userdao.queryUserList();
            req.setAttribute("userlist",userlist);
            String updateSuccess = "updateSuccess";
            req.setAttribute("updateSuccess",updateSuccess);
            req.getRequestDispatcher("login/usersManger/userList.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect( "login/loginFill.jsp");
        }
    }
}
