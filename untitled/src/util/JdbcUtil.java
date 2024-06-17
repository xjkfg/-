package util;

import java.sql.*;

public class JdbcUtil {
    private static  String url="jdbc:mysql://localhost:3306/homework";
    private static  String username="root";
    private static  String password="229970937";
    private Connection conn;


    //1.创建链接
    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            if(conn==null||conn.isClosed())
            {
                conn = DriverManager.getConnection(url,username,password);
                //conn=DriverManager.getConnection("jdbc:mysql://10.254.1.38:3306/homework","developer", "Javaweb@0102");
                System.out.println("数据库连接成功");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败，可以执行sql语句了");
            e.printStackTrace();
            return null;
        }
        return conn;
    }


    public boolean prepareInsert(String sql, Object... param) {
        try {
            getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 不需要再检查 pstmt 是否为 null，因为 prepareStatement 很少返回 null
            // （除非 conn 无效或 SQL 语句有严重问题）
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            int rs = pstmt.executeUpdate();

            System.out.println(0);
            System.out.println(rs);

            if (rs >= 0) { // 对于 INSERT 操作，executeUpdate 通常返回 1（或受影响的行数）
                System.out.println("插入数据成功");
                // 注意：通常不建议在这里关闭 conn，因为它可能是连接池中的连接
                // conn.close(); // 移除这一行，除非 conn 不是连接池中的连接
                return true;
            } else {
                System.out.println("插入数据失败，但 rs 通常不会是负数，除非有特殊情况");

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }
    //3.执行查询语句
    public ResultSet query(String sql, Object ...param){
        try {
            getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt ;
        ResultSet rs=null;

        try {
            pstmt = conn.prepareStatement(sql);
            if(param!=null)
            {
                for(int i=0;i< param.length;i++)
                {
                    pstmt.setObject(i+1,param[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //4.执行修改语句
    public boolean update(String sql,Object ...param){
        try {
            getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int rs=0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(param!=null)
            {
                for(int i=0;i< param.length;i++)
                {
                    pstmt.setObject(i+1,param[i]);
                }
            }
            rs = pstmt.executeUpdate();
            if(rs>=0)
            {
                System.out.println("修改数据成功");
                return true;
            }
            System.out.println("修改数据失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //5.执行删除语句
    public boolean delete(String sql,Object ...param){
        try {
            getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            PreparedStatement pstmt = pstmt = conn.prepareStatement(sql);;

            if(pstmt==null)
            {
                System.out.println("失败");
                return false;
            }
            if(param!=null)
            {
                for(int i=0;i< param.length;i++)
                {
                    pstmt.setObject(i+1,param[i]);
                }
            }else{
                System.out.println("用户为空");
            }
            int rs= pstmt.executeUpdate();
            if(rs>0)
            {
                System.out.println("删除数据成功");
                return true;
            }
            System.out.println("删除数据失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //6.关闭连接
    public void closerConnection()  {
        try {
            if(conn!=null&&!conn.isClosed()) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("数据库已经关闭");
                }
            }
        } catch (SQLException e) {
            System.out.println("关闭失败");
        }
    }
}
