package ExpressionLanguage.CreateOrder;

public class JudgeOrder {

    private Order order = null;

    private int key = -1;

    public JudgeOrder(Order order) {
        this.init();
        this.setOrder(order);

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

        } else if (this.getOrder().getGood_number() < 0) {
            //你需求是不存在的

        }
    }
}
