package servlet;

import dao.userDao;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/queryList.do")
public class queryUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber=req.getParameter("page");
        int page = pageNumber == null ? 1 : Integer.parseInt(pageNumber);
        userDao userdao=new userDao();
        List<User> user=userdao.queryUserList();
        List<User> userlist=new ArrayList<>();

        for(int i=(page-1)*10;i<Math.min(page*10,user.size());i++)
        {
            userlist.add(user.get(i));
        }

        req.setAttribute("userlist",userlist);

        req.getRequestDispatcher("login/usersManger/userList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("queryUsername");
        userDao userdao=new userDao();

        System.out.println("queryUserListServlet");

        if(username!="")
        {
            System.out.println("进行精准查询");

            List<User>  userlist = userdao.queryUserList(username);
            if(userlist!=null)
            {

                System.out.println("查询到搜索用户");

                req.setAttribute("userlist",userlist);
                String userManger = req.getParameter("userManger");
                System.out.println(userManger);
                System.out.println(userlist);

                /*if("2".equals(userManger))
                {
                    System.out.println("删除用户页面");
                    req.getRequestDispatcher("login/usersManger/userDelete.jsp").forward(req,resp);
                }
                else if("3".equals(userManger))
                {
                    System.out.println("修改用户页面");
                    req.getRequestDispatcher("login/usersManger/userUpdate.jsp").forward(req,resp);
                }
                else{*/
                    System.out.println("查询用户页面");
                    req.getRequestDispatcher("login/usersManger/userList.jsp").forward(req,resp);
                //}

            }
            else{
                System.out.println("错误");
            }
        }

        else{
            System.out.println("查询所有用户列表");

            List<User>  userlist = userdao.queryUserList();
            if(userlist!=null)
            {

                String userManger = req.getParameter("userManger");

                //页面大小
                int pageSize = 10;
                //用户总数
                int totalUser = userlist.size();
                System.out.println(totalUser);

                int totalPage = (int)Math.ceil((double)totalUser/pageSize);

                System.out.println(totalPage);

                HttpSession session1 = req.getSession();
                HttpSession session2 = req.getSession();

                session1.setAttribute("userlist",userlist);
                session2.setAttribute("totalPage",totalPage);

                req.setAttribute("totalUser",totalUser);
                req.setAttribute("pageSize",pageSize);

                /*if("2".equals(userManger))
                {
                    System.out.println("删除用户页面");
                    req.getRequestDispatcher("login/usersManger/userDelete.jsp").forward(req,resp);
                }
                else if("3".equals(userManger))
                {
                    System.out.println("修改用户页面");
                    req.getRequestDispatcher("login/usersManger/userUpdate.jsp").forward(req,resp);
                }
                else{*/
                    System.out.println("查询用户页面");
                    req.getRequestDispatcher("login/usersManger/userList.jsp").forward(req,resp);
                //}
            }

            else{
                System.out.println("错误");
            }
        }
    }
}
