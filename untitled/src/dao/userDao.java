package dao;

import user.User;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userDao {

    /**
     *登录比对用户
     */
    public User findByUsername(String username, String password){

        try {
            //1.创建调用JDBC工具类
            JdbcUtil jdbcUtil=new JdbcUtil();
            //2.连接数据库
            jdbcUtil.getConnection();
            //3.要执行的sql语句
            String sql = "SELECT * FROM `02_37_xhy_user` WHERE username = ? AND password = ?";
            //4.调用方法实现
            ResultSet rs=jdbcUtil.query(sql,username,password);

            //5.处理查询结果
            if (rs.next()) {
                System.out.println("有数据");
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setProfession(rs.getString("profession"));
                user.setFavor(rs.getString("favor"));
                user.setStatus(rs.getString("status"));
                user.setRole(rs.getString("role"));
                System.out.println(user.getUsername()+" "+user.getPassword());
                jdbcUtil.closerConnection();
                return user;
            }
            else {
                System.out.println("没数据");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 精准查询用户
     */
    public List<User> queryUserList(String username){
        List<User> list = new ArrayList<>();
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {

            jdbcUtil.getConnection();

            String sql = "SELECT * FROM 02_37_xhy_user where 1=1"; // 确保表名是正确的

            sql+=" and username like ?";
            ResultSet rs = jdbcUtil.query(sql,username);

            System.out.println(sql);

            // 4. 处理查询结果
            if(rs.next())
            {
                System.out.println("查询里有内容");
                    User user = new User();

                    user.setUsername(rs.getString("username"));

                    user.setPassword(rs.getString("password"));

                    user.setGender(rs.getString("gender"));

                    user.setProfession(rs.getString("profession"));

                    user.setFavor(rs.getString("favor"));

                    user.setDescription(rs.getString("description"));

                    user.setRole(rs.getString("role"));

                    user.setStatus(rs.getString("status"));

                    System.out.println(rs.getString("username")+" "+rs.getString("password"));

                    list.add(user);

                return list;
            }
            else{
                System.out.println("没有查询到用户");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closerConnection();
        }
        return null;
    }

    /**
     * 查询所有用户
     */
    public List<User> queryUserList(){
        List<User> list = new ArrayList<>();
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {

            jdbcUtil.getConnection();

            String sql = "SELECT * FROM 02_37_xhy_user "; // 确保表名是正确的

            ResultSet rs=null;

            rs = jdbcUtil.query(sql);

            System.out.println(sql);

            System.out.println(rs);
            // 4. 处理查询结果
                while (rs.next()) {
                    User user = new User();

                    user.setUsername(rs.getString("username"));

                    user.setPassword(rs.getString("password"));

                    user.setGender(rs.getString("gender"));

                    user.setProfession(rs.getString("profession"));

                    user.setFavor(rs.getString("favor"));

                    user.setDescription(rs.getString("description"));

                    user.setRole(rs.getString("role"));

                    user.setStatus(rs.getString("status"));

                    list.add(user);
                }
                return list;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closerConnection();
        }
        return null;
    }

    /**
     * 根据姓名删除用户
     */
    public boolean deleteByUserName(String username){
        //1.调用JDBC工具类
        JdbcUtil jdbcUtil=new JdbcUtil();

        String sql="delete from 02_37_xhy_user where username like ?";

        boolean rs=jdbcUtil.delete(sql,username);

        if(rs)
        {
            System.out.println("删除数据成功！");
            return true;
        }
        return false;
    }

    /**
     * 根据姓名修改用户
     */
    public boolean updateUser(String username, String password, String gender, String profession, String favor, String description, String role, String status,String usernames){
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            //1.创建链接
            jdbcUtil.getConnection();
            //2.准备sql语句
            String sql = "update 02_37_xhy_user set username=? ,password=? ,gender =? ,profession=? ,favor=? ,description=? , role=? ,status=? where username like ?";
            //3.判断执行结果
            boolean rs = jdbcUtil.update(sql,username,password,gender,profession,favor,description,role,status,usernames);
            if(rs)
            {
                System.out.println("修改用户成功");
                return true;
            }
            else{
                System.out.println("修改用户失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.closerConnection();
        }
        return false;
    }
    /**
     * 新增一个用户
     */
    public boolean insertUser(String username, String password, String gender, String profession, String favor, String description, String role, String status){
        //1.调用JDBC工具类
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            jdbcUtil.getConnection();

            //2.准备sql语句
            String sql="insert into 02_37_xhy_user(username,password,gender,profession,favor,description,role,status) values (?,?,?,?,?,?,?,?)";
            boolean rs=jdbcUtil.prepareInsert(sql,username,password,gender,profession,favor,description,role,status);

            if(rs)
            {
                System.out.println("插入数据成功！");
                return true;
            }
            else System.out.println("插入数据失败！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.closerConnection();
        }
        return false;
    }

    /**
     * 修改密码
     */

    /**
     * 禁用用户权限
     */

    /**
     * 重置密码
     */


    /**
     * 将数据库抽象出来
     */
    private static User converToUser(ResultSet rs) throws SQLException {
        User user=new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setGender(rs.getString("gender"));
        user.setProfession(rs.getString("profession"));
        user.setFavor(rs.getString("favor"));
        return user;
    }

}

