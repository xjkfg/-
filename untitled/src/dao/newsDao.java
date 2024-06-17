package dao;

import user.News;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class newsDao {

    /**
     * 精准查询新闻
     */
    public List<News> queryNewsList(String author){
        List<News> list=new ArrayList<>();
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            jdbcUtil.getConnection();

            String sql="SELECT * FROM 02_37_xhy_news where author like ?";

            ResultSet rs=jdbcUtil.query(sql,author);

            System.out.println("queryNewsList");
            System.out.println(rs);

            while(rs.next()){
                System.out.println("新闻列表里面有内容");
                News news=new News();

                news.setTitle(rs.getString("title"));
                news.setAuthor(rs.getString("author"));
                news.setState(rs.getString("state"));
                news.setCategory(rs.getString("category"));
                news.setCoverUrl(rs.getString("cover_url"));
                news.setContent(rs.getString("content"));
                news.setViewCount(rs.getInt("view_count"));

                list.add(news);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 查询所有新闻列表
     */
    public List<News> queryNewsList(){
        List<News> list=new ArrayList<>();
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            jdbcUtil.getConnection();

            String sql="SELECT * FROM 02_37_xhy_news ";

            ResultSet rs=jdbcUtil.query(sql);

            System.out.println("queryNewsList");
            System.out.println(rs);

                while(rs.next()){
                    System.out.println("新闻列表里面有内容");
                    News news=new News();

                    news.setTitle(rs.getString("title"));
                    news.setAuthor(rs.getString("author"));
                    news.setState(rs.getString("state"));
                    news.setCategory(rs.getString("category"));
                    news.setCoverUrl(rs.getString("cover_url"));
                    news.setContent(rs.getString("content"));
                    news.setViewCount(rs.getInt("view_count"));

                    list.add(news);
                }
                return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增新闻
     */
    public boolean insertNews(String title,String author,String state,String category,String coverUrl,String content,int viewCount){
        //1.调用JDBC工具类
        JdbcUtil jdbcUtil=new JdbcUtil();

        try {
            //连接数据库
            jdbcUtil.getConnection();

            //2.准备sql语句
            String sql="insert into 02_37_xhy_news(title,author,state,category,cover_url,content,view_count)  values (?,?,?,?,?,?,?)";
            boolean rs=jdbcUtil.prepareInsert(sql,title,author,state,category,coverUrl,content,viewCount);

            if(rs)
            {
                System.out.println("插入新闻成功！");
                return true;
            }
            else System.out.println("插入新闻失败！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
    * 根据作者删除新闻
    */
    public boolean deleteNews(String author) {
        //1.调用JDBC个工具类
        JdbcUtil jdbcUtil = new JdbcUtil();
        //2.sql语句
        String sql="delete from 02_37_xhy_news where author like ?";
        //3.进行数据库操作
        boolean rs=jdbcUtil.delete(sql,author);
        //判断数据库操作是否成功
        if(rs)
        {
            System.out.println("删除数据成功");
            return true;
        }
        return false;
    }

    /**
     * 根据作者修改新闻
     */
    public boolean updateNews(String title,String author,String state,String category,String content,String authors){
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            //1.创建链接
            jdbcUtil.getConnection();
            //2.准备sql语句
            String sql = "update 02_37_xhy_news set title=? ,author=? ,state =? ,category=? ,content=? where author like ?";
            //3.判断执行结果
            boolean rs = jdbcUtil.update(sql,title,author,state,category,content,authors);
            System.out.println(rs);
            if(rs)
            {
                System.out.println("修改新闻成功");
                return true;
            }
            else{
                System.out.println("修改新闻失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.closerConnection();
        }
        return false;
    }
}
