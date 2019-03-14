package ExpressionLanguage.AddGoods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaveGoodsTest {

    private SaveGoods saveGoods = null;

    @Before
    public void setUp() throws Exception {
        Good good = new Good();
        good.setGood_name("ink");
        good.setGood_number(1000);
        good.setGood_price(2003);
        saveGoods = new SaveGoods(good);
    }

    @Test
    public void paly() {
        System.out.println(saveGoods.isKey());
    }
}