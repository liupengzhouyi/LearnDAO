package ExpressionLanguage.Landing;

import ExpressionLanguage.LinkDatabase.Linkdatabase;
import ExpressionLanguage.Registered.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeUser {

    private User user = null;

    private boolean key = false;

    private String sql = null;

    public JudgeUser(User user) throws SQLException, ClassNotFoundException {
        this.init();
        this.setUser(user);
        this.setSql(this.getUser().getUser_id());
        this.linkDataBase();
    }

    public void init() {
        this.user = new User();
        this.sql = new String();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String user_id) {
        this.sql = "select user_password from el_user_table where user_id = " + user_id + ";";
    }

    public void linkDataBase() throws ClassNotFoundException, SQLException {
        Linkdatabase linkdatabase = new Linkdatabase();

        ResultSet resultSet = linkdatabase.getInformation(this.getSql());

        if (resultSet == null) {
            System.out.println("没有该用户！");
            this.setKey(false);
        } else {

            String password = "";
            while(resultSet.next()) {
                password = resultSet.getString("user_password");
            }
            if (this.getUser().getUser_password().equals(password)) {
                this.setKey(true);
            } else {
                System.out.println("密码错误！");
                this.setKey(false);
            }

        }
    }
}
