package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.GetGoods.JudgeGoodId;

import java.sql.SQLException;


/**
 * getKey()方法
 * 0：正常要求
 * 1：你的要求数量太大
 * 2：你的要求数量太小
 * 3：库存量不足
 */
public class JudgeOrder {

    private Order order = null;

    private int key = -1;

    public JudgeOrder(Order order) throws SQLException, ClassNotFoundException {
        this.init();
        this.setOrder(order);
        this.judgeNumber();
        if (this.getKey() == 0) {
            this.judgeOrderNumber();
        }
    }

    /**
     * 初始化函数
     */
    public void init() {
        this.order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * 验证你的订单的商品的数量；
     */
    public void judgeNumber() {
        if (this.getOrder().getGood_number() > 999999) {
            // 你的需求太大
            this.setKey(1);
        } else if (this.getOrder().getGood_number() < 0) {
            System.out.println("----------:" + this.getOrder().getGood_number());
            //你需求是不存在的
            this.setKey(2);
        } else {
            //正常操作
            this.setKey(0);
        }
    }


    /**
     * 验证你的要求与库存量的关系
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void judgeOrderNumber() throws SQLException, ClassNotFoundException {

        JudgeGoodId judgeGoodId = new JudgeGoodId(this.getOrder().getGood_id() + "");

        int goodAllNumber = judgeGoodId.getGood().getGood_number();

        if (goodAllNumber >= this.getOrder().getGood_number()) {
            //库存量足够
            this.setKey(0);
        } else {
            //库存量不足
            this.setKey(3);
        }

    }
}
