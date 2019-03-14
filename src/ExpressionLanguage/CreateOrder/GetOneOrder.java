package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.LinkDatabase.Linkdatabase;
import ExpressionLanguage.Registered.RegisteredUserInfoemationServlet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetOneOrder {

    private Order order = null;

    private Order youOrder = null;

    private Linkdatabase linkdatabase = null;

    private String sql = null;

    public GetOneOrder(Order youOrder) throws ClassNotFoundException {
        this.init();

        this.setYouOrder(order);

        this.setSql();

    }

    /**
     * 初始化
     * @throws ClassNotFoundException
     */
    public void init() throws ClassNotFoundException {
        this.order = new Order();
        this.youOrder = new Order();
        this.sql = new String();
        this.linkdatabase = new Linkdatabase();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder() throws SQLException {
        ResultSet resultSet = this.getLinkdatabase().getInformation(this.getSql());

        while (resultSet.next()) {

        }
    }

    public Order getYouOrder() {
        return youOrder;
    }

    public void setYouOrder(Order youOrder) {
        this.youOrder = youOrder;
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

    public void setSql() {
        String good_id = this.getYouOrder().getGood_id() + "";
        this.sql = "";
    }


}
