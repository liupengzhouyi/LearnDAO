package ExpressionLanguage.AddGoods;

public class JudegGood {

    private Good good = null;

    private int key = 0;

    public JudegGood(Good good) {
        this.init();
        this.setGood(good);
        this.judegGoodName();
        if (this.getKey() == 0) {
            this.judegGoodPrice();
            if (this.getKey() == 0) {
                this.judegGoodPrice();
            }
        }
    }

    public void init() {
        this.good = new Good();
    }

    /**
     * 校验商品名称
     * 名称>20 --> 1
     * 名称<0 && 名称 > 20 --> 0
     * 名称 == 0 --> 2
     */
    public void judegGoodName() {
        int goodNameLength = this.getGood().getGood_name().length();
        if (goodNameLength > 20) {
            this.setKey(1);
        } else if(goodNameLength == 0) {
            this.setKey(2);
        } else {
            this.setKey(0);
        }
    }

    /**
     * 校验商品的数量
     * 上屏数量大于0 --> 0
     * 商品数量小于等于0 --> 3
     * 商品数量超过100000 --> 6
     */
    public void judegGoodNumber() {
        int number = Integer.valueOf(this.getGood().getGood_number());
        if (number > 0) {
            if(number > 999999) {
                this.setKey(5);
            } else {
                this.setKey(0);
            }
        } else {
            this.setKey(3);
        }
    }

    /**
     * 校验商品的价格
     * 商品价格 > 0 --> 0
     * 商品价格 < 0 --> 4
     * 商品价格 > 10万 --> 6
     */
    public void judegGoodPrice() {
        int price = Integer.valueOf(this.getGood().getGood_price());
        if (price > 0) {

            if (price > 99999) {
                this.setKey(6);
            } else {
                this.setKey(0);
            }
        } else {
            this.setKey(4);
        }
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    /**
     * 0:正常
     * 1：名字太长
     * 2：名字没有输入
     * 3：商品数量太小
     * 4：太便宜，不要钱
     * 5：太多，库存超过10万
     * 6: 太贵，单品价格超过10万元
     * @return
     */
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
