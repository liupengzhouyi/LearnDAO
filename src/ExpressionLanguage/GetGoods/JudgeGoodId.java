package ExpressionLanguage.GetGoods;

import ExpressionLanguage.AddGoods.Good;
import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeGoodId {

    private boolean key = false;

    private String sql = null;

    private Good good = null;

    private Linkdatabase linkdatabase = null;

    private String good_id = null;

    public JudgeGoodId(String good_id) throws ClassNotFoundException, SQLException {
        this.init();
        this.setGood_id(good_id);
        //设置SQL语句
        this.setSql();
        //获取数据
        this.getGoodData();
    }

    public void init() throws ClassNotFoundException {
        this.linkdatabase = new Linkdatabase();
        this.good = new Good();
        this.sql = new String();
        this.key = false;
        this.good_id = new String();
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

    public void setSql() {
        this.sql = "select * from el_goods where good_id = "+ this.getGood_id() +";";
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Linkdatabase getLinkdatabase() {
        return linkdatabase;
    }

    public void setLinkdatabase() throws ClassNotFoundException {
        this.linkdatabase = new Linkdatabase();
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    /**
     * 获取数据库中的数据
     * @throws SQLException
     */
    public void getGoodData() throws SQLException {
        System.out.println(this.getSql());

        ResultSet resultSet = this.getLinkdatabase().getInformation(this.getSql());

        while(resultSet.next()) {
            int good_id = resultSet.getInt("good_id");
            String good_name = resultSet.getString("good_name");
            int good_price = resultSet.getInt("good_price");
            int good_number = resultSet.getInt("good_number");

            this.setKey(true);

            this.getGood().setGood_id(good_id);
            this.getGood().setGood_name(good_name);
            this.getGood().setGood_price(good_price);
            this.getGood().setGood_number(good_number);
        }
    }
}
