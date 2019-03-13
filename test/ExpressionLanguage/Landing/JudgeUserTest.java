package ExpressionLanguage.Landing;

import ExpressionLanguage.Registered.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeUserTest {

    private JudgeUser judgeUser = null;

    @Before
    public void setUp() throws Exception {

        User user = new User();

        user.setUser_id("3");
        user.setUser_password("1234567");

        judgeUser = new JudgeUser(user);

    }

    @Test
    public void paly() {
        System.out.println(judgeUser.isKey());
    }


    @After
    public void tearDown() throws Exception {
    }
}