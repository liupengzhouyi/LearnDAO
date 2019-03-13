package ExpressionLanguage.Registered;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.SQLException;

public class SaveUserData {

    private User user = null;

    private String sql = null;

    public SaveUserData(User user) {
        this.init();
        //注册用户
        this.setUser(user);
        //转化SQL语句
        this.setSql();
    }

    /**
     * 初始化
     */
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

    public String getSql() {
        return sql;
    }

    public void setSql() {
        User user = this.getUser();
        this.sql = "insert into el_user_table(user_name, user_password) value (\'" + user.getUser_name() + "\', \'" + user.getUser_password() + "\');";
    }

    public void save() throws ClassNotFoundException, SQLException {
        Linkdatabase linkdatabase = new Linkdatabase();

        boolean key = linkdatabase.saveData(this.getSql());

        if (key == true) {
            System.out.println("注册用户数据保存成功！");
        } else {
            System.out.println("注册用户数据没有保存成功！");
        }
    }

}
