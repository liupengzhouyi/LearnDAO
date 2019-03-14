package ExpressionLanguage.GetGoods;

import ExpressionLanguage.AddGoods.Good;
import ExpressionLanguage.LinkDatabase.Linkdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAllGoods {

    private List<Good> listOfGoods = null;

    private Linkdatabase linkdatabase = null;

    private String sql = null;

    private ResultSet resultSet = null;

    public GetAllGoods() throws ClassNotFoundException, SQLException {
        this.init();
        this.setSql();

        this.getData();
    }

    /**
     * 初始化函数
     * @throws ClassNotFoundException
     */
    public void init() throws ClassNotFoundException {
        this.sql = new String();
        this.linkdatabase = new Linkdatabase();
        listOfGoods = new ArrayList<Good>();
    }

    public List<Good> getListOfGoods() {
        return listOfGoods;
    }

    public void setListOfGoods(List<Good> listOfGoods) {
        this.listOfGoods = listOfGoods;
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
        this.sql = "select * from el_goods;";
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * 获取数据
     */
    public void getData() throws SQLException {
        this.setResultSet(this.getLinkdatabase().getInformation(this.getSql()));

        while(this.getResultSet().next()) {
            //获取数据
            int good_id = this.getResultSet().getInt("good_id");
            String good_name = this.getResultSet().getString("good_name");
            int good_price = this.getResultSet().getInt("good_price");
            int good_number = this.getResultSet().getInt("good_number");
            //构件数据类
            Good good = new Good();
            good.setGood_id(good_id);
            good.setGood_name(good_name);
            good.setGood_price(good_price);
            good.setGood_number(good_number);

            //数据类加入list
            this.getListOfGoods().add(good);
        }
    }
}
