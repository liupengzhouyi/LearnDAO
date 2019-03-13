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
        this.setSql();
        this.getID();
    }

    public void init() {
        this.user_id = new String();
        this.userName = new String();
        this.sql = new String();
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
