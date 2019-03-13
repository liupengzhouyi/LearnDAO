package ExpressionLanguage.Landing;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserName {

    private String user_id = null;

    private String userName = null;

    private String sql = null;

    private Linkdatabase linkdatabase = null;


    public GetUserName(String user_id) throws ClassNotFoundException, SQLException {
        this.init();
        this.setUser_id(user_id);
        this.setSql();
        System.out.println(this.getSql());
        this.getNameByID();

    }

    public void init() {
        this.user_id = new String();
        this.userName = new String();
        this.sql = new String();
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql() {
        this.sql = "select user_name from el_user_table where user_id = " + this.getUser_id() + ";";
    }

    public String getUserName() {
        return this.userName;
    }


    public void getNameByID() throws ClassNotFoundException, SQLException {
        linkdatabase = new Linkdatabase();

        ResultSet resultSet = linkdatabase.getInformation(this.getSql());

        String name = "";

        while(resultSet.next()) {
            name = resultSet.getString("user_name");
        }

        this.setUserName(name);

        System.out.println(name);
    }
}
