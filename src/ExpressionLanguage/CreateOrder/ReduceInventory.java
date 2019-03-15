package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ReduceInventory {

    private Order order = null;

    private Linkdatabase linkdatabase = null;

    private String getSQL = null;

    private String saveSQL = null;

    private int endNumber = -1;

    private boolean key = false;

    public ReduceInventory(Order order) throws ClassNotFoundException, SQLException {
        this.init();
        this.setOrder(order);
        //获取原来的库存量
        this.setGetSQL();
        //获取原库存量数据
        this.getOrdOrder();
        //设置新的库存量
        this.setNewEndNumber();
        //更新全新的库存量
        this.setSaveSQL();
        //更新数据库
        this.updateNewGoodNumber();
    }

    /**
     * 初始化函数
     * @throws ClassNotFoundException
     */
    public void init() throws ClassNotFoundException {
        this.endNumber = -1;
        this.saveSQL = new String();
        this.getSQL = new String();
        this.linkdatabase = new Linkdatabase();
        this.order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Linkdatabase getLinkdatabase() {
        return linkdatabase;
    }

    public void setLinkdatabase(Linkdatabase linkdatabase) {
        this.linkdatabase = linkdatabase;
    }

    public String getGetSQL() {
        return getSQL;
    }

    /**
     * 获取原库存量
     */
    public void setGetSQL() {
        this.getSQL = "select * from el_goods where good_id = " + this.getOrder().getGood_id() + ";";
    }

    public String getSaveSQL() {
        return saveSQL;
    }

    /**
     * 修改库存量
     */
    public void setSaveSQL() {
        this.saveSQL = "update el_goods set good_number = " + this.getEndNumber() + " where good_id = " + this.getOrder().getGood_id() + ";";
    }

    public int getEndNumber() {
        return endNumber;
    }

    /**
     * 设置库存量
     */
    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    /**
     * 设置新的库存量
     */
    public void setNewEndNumber() {
        this.endNumber = this.getEndNumber() - this.getOrder().getGood_number();
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    /**
     * 获取愿库存量数据
     * @throws SQLException
     */
    public void getOrdOrder() throws SQLException {
        ResultSet resultSet = linkdatabase.getInformation(this.getGetSQL());
        while(resultSet.next()) {
            int num = resultSet.getInt("good_number");
            this.setEndNumber(num);
        }
    }

    /**
     * 更新新的库存量
     * @throws SQLException
     */
    public void updateNewGoodNumber() throws SQLException {
        boolean key = false;
        key = this.getLinkdatabase().updateData(this.getSaveSQL());
        this.setKey(key);
    }
}
