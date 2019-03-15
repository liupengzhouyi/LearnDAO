package ExpressionLanguage.JudgeUser;

import ExpressionLanguage.Registered.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserIsRightTest {

    private User user = null;

    private UserIsRight userIsRight = null;

    @Before
    public void setUp() throws Exception {

        user = new User();

        user.setUser_id("3");

        user.setUser_password("1234567");

        user.setUser_name("liupeng");

        userIsRight = new UserIsRight(user);

    }

    @Test
    public void paly() {
        System.out.println(userIsRight.isKey());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserIsRight getUserIsRight() {
        return userIsRight;
    }

    public void setUserIsRight(UserIsRight userIsRight) {
        this.userIsRight = userIsRight;
    }
}