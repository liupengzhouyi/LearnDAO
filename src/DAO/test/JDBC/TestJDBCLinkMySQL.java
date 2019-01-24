package DAO.test.JDBC;

import DAO.link.JDBC.LinkDatabase;

import java.sql.Connection;

public class TestJDBCLinkMySQL {
    public static void main(String[] args) {
        LinkDatabase linkDatabase = new LinkDatabase();

        Connection connection = linkDatabase.getConnection();

        if (connection == null) {
            System.out.println("数据库连接失败！");
        } else {
            System.out.println("数据库连接成功！");
        }

        linkDatabase.close();
    }
}
