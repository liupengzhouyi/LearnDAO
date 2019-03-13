package ExpressionLanguage.Registered;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserID {

    private String userID = null;

    private String sql = null;

    private Linkdatabase linkdatabase = null;

    private int user_id = 0;

    public GetUserID() throws ClassNotFoundException, SQLException {
        this.init();
        this.setSql();
        this.getID();
    }

    public void init() {
        this.userID = new String();
        this.sql = new String();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSql() {
        return sql;
    }

    public void setSql() {
        this.sql = "select user_id from el_user_table;";
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void getID() throws ClassNotFoundException, SQLException {
        linkdatabase = new Linkdatabase();

        ResultSet resultSet = linkdatabase.getInformation(this.getSql());

        int number= -1;

        while(resultSet.next()) {
            number = resultSet.getInt("user_id");
        }

        this.setUser_id(number);

        System.out.println(number);
    }


}

