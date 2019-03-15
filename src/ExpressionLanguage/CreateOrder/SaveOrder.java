package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.SQLException;

public class SaveOrder {

    private Order order = null;

    private String sql = null;

    private Linkdatabase linkdatabase = null;

    private int key = -1;

    public SaveOrder(Order order) throws ClassNotFoundException, SQLException {
        this.init();
        this.setOrder(order);
        this.setSql();
        this.saveOrderInformation();
    }

    public void init() throws ClassNotFoundException {
        this.key = -1;
        this.order = new Order();
        this.linkdatabase = new Linkdatabase();
        this.sql = new String();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getSql() {
        return sql;
    }

    /**
     * 创建SQL语句
     */
    public void setSql() {
        this.sql = "insert into el_order(order_user_id, order_goods_id, order_goods_number) value " +
                "(" + this.getOrder().getUser_id() + ", " + this.getOrder().getGood_id() + ", " + this.getOrder().getGood_number() + ");";
        //System.out.println(this.sql);
    }

    public Linkdatabase getLinkdatabase() {
        return linkdatabase;
    }

    public void setLinkdatabase(Linkdatabase linkdatabase) {
        this.linkdatabase = linkdatabase;
    }

    /**
     * -1 : 没有进行数据库入库操作
     *  0 : 操作成功
     *  1 : 操作失败
     * @return
     */
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * 保存数据
     * @throws SQLException
     */
    public void saveOrderInformation() throws SQLException {
        boolean key = this.getLinkdatabase().saveData(this.getSql());
        if (key == true) {
            this.setKey(0);
        } else {
            this.setKey(1);
        }

    }


}
