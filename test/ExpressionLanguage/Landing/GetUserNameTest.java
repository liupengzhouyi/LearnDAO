package ExpressionLanguage.Landing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GetUserNameTest {

    private GetUserName getUserName = null;

    @Before
    public void setUp() throws Exception {
        getUserName = new GetUserName("3");
    }

    @Test
    public void saySQL() {
        System.out.println(getUserName.getSql());
    }


    @Test
    public void paly() throws SQLException, ClassNotFoundException {
        System.out.println(getUserName.getUserName());
    }

    @After
    public void tearDown() throws Exception {
    }
}