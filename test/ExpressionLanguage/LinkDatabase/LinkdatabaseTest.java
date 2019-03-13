package ExpressionLanguage.LinkDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class LinkdatabaseTest {

    private Linkdatabase linkdatabase = null;

    @Before
    public void setUp() throws Exception {

        linkdatabase = new Linkdatabase();

    }

    @Test
    public void testLink() throws SQLException {
        Connection connection = linkdatabase.getConnection();

        if (connection != null) {
            System.out.println("数据库连接成功！");
        } else {
            System.out.println("数据库连接失败！");
        }
    }

    @After
    public void tearDown() throws Exception {
    }

}