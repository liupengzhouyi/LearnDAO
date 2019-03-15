package ExpressionLanguage.JudgeUser;

import ExpressionLanguage.LinkDatabase.Linkdatabase;
import ExpressionLanguage.Registered.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIsRight {

    private User user = null;

    private String sql = null;

    private Linkdatabase linkdatabase = null;

    private boolean key = false;

    UserIsRight(User user) throws ClassNotFoundException, SQLException {
        init();
        this.setUser(user);
        this.setSql();
        this.findUser();

    }

    public void init() throws ClassNotFoundException {
        this.user = new User();
        this.sql = new String();
        this.linkdatabase = new Linkdatabase();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSql() {
        return sql;
    }

    public void setSql() {
        this.sql = "select * from el_user_table where user_id = " + this.getUser().getUser_id() + " and user_password = \'" + this.getUser().getUser_password() + "\';";
    }

    public Linkdatabase getLinkdatabase() {
        return linkdatabase;
    }

    public void setLinkdatabase(Linkdatabase linkdatabase) {
        this.linkdatabase = linkdatabase;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    /**
     * 找到了你的验证
     * @throws SQLException
     */
    public void findUser() throws SQLException {
        ResultSet resultSet = this.linkdatabase.getInformation(this.getSql());

        while (resultSet.next()) {
            this.setKey(true);
        }
    }

}
