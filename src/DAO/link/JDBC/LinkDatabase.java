package DAO.link.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkDatabase {

    //定义数据库驱动类
    private final String DBDRIVER = "com.mysql.jdbc.Driver";
    //定义数据库连接URL
    private final String DBURL = "jdbc:mysql://localhost:3306/javaDataBase";
    //定义数据库连接用户名
    private final String DBUSER = "root";
    //定义密码
    private final String DBPASSWORD = "Lp184126";
    //定义连接对象
    private Connection conn = null;

    //构造方法，加载驱动
    public LinkDatabase(){
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }catch(Exception e){
            System.out.println("加载驱动失败");
        }
        System.out.println("数据库驱动加载成功！");
    }

    //取得数据库连接
    public Connection getConnection(){
        return conn;
    }

    //关闭数据库
    public void close(){
        /*try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        this.conn = null;
        if (this.conn == null) {
            System.out.println("数据库连接已关闭！");
        } else {
            System.out.println("数据库连接关闭失败！");
        }
    }

}
