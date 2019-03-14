package ExpressionLanguage.AddGoods;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.SQLException;

public class SaveGoods {

    private Good good = null;

    private boolean key = false;

    private Linkdatabase linkdatabase = null;

    private String sql = null;

    public SaveGoods(Good good) throws ClassNotFoundException, SQLException {
        //初始化
        this.init();
        //注入商品
        this.setGood(good);
        //创建商品保存语句
        this.setSql();
        //保存上屏数据
        this.save();
    }

    /**
     * 初始化
     * @throws ClassNotFoundException
     */
    public void init() throws ClassNotFoundException {
        this.good = new Good();
        this.key = false;
        this.linkdatabase = new Linkdatabase();
        this.sql = new String();
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public Linkdatabase getLinkdatabase() {
        return linkdatabase;
    }

    public void setLinkdatabase(Linkdatabase linkdatabase) {
        this.linkdatabase = linkdatabase;
    }

    public String getSql() {
        return sql;
    }

    /**
     * 设置商品保存语句
     */
    public void setSql() {
        this.sql = "insert into el_goods(good_name, good_price, good_number) " +
                "value (\'" + this.getGood().getGood_name() + "\', " + this.getGood().getGood_price() + ", " + this.getGood().getGood_number() + ");";
    }

    /**
     * 保存商品数据
     * @throws SQLException
     */
    public void save() throws SQLException {
        this.setKey(linkdatabase.saveData(this.getSql()));
    }
}

