package ExpressionLanguage.AddGoods;

public class Good {

    private int good_id;

    private String good_name;

    private int good_price;

    private int good_number;

    private String good_url;

    /**
     * 初始化函数
     */
    public void init() {
        this.good_id = -1;
        this.good_name = new String();
        this.good_number = -1;
        this.good_price = -1;
        this.good_url = new String();
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getGood_price() {
        return good_price;
    }

    public void setGood_price(int good_price) {
        this.good_price = good_price;
    }

    public int getGood_number() {
        return good_number;
    }

    public void setGood_number(int good_number) {
        this.good_number = good_number;
    }

    public String getGood_url() {
        return good_url;
    }

    public void setGood_url(String good_url) {
        this.good_url = good_url;
    }
}
