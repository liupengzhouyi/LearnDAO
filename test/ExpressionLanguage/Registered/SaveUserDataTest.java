package ExpressionLanguage.Registered;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class SaveUserDataTest {

    private SaveUserData saveUserData = null;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUser_id("123");
        user.setUser_name("liupeng");
        user.setUser_password("12345678");
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_password());
        System.out.println(user.getUser_id());
        saveUserData = new SaveUserData(user);
    }

    @Test
    public void say() {
        System.out.println(saveUserData.getSql());
    }

    @Test
    public void save() throws SQLException, ClassNotFoundException {
        saveUserData.save();
    }

    @After
    public void tearDown() throws Exception {
    }
}