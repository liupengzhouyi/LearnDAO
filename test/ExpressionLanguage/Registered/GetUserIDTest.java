package ExpressionLanguage.Registered;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GetUserIDTest {

    private GetUserID getUserID = null;

    @Before
    public void setUp() throws Exception {
        getUserID = new GetUserID();
    }

    @Test
    public void paly() throws SQLException, ClassNotFoundException {
        getUserID.getID();
    }

    @After
    public void tearDown() throws Exception {
    }
}