package ExpressionLanguage.AddGoods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudegGoodTest {

    private JudegGood judegGood = null;

    @Before
    public void setUp() throws Exception {
        Good good = new Good();
        good.setGood_name("");
        System.out.println(good.getGood_name().length());
        good.setGood_number(100);
        good.setGood_price(200);
        judegGood = new JudegGood(good);
    }


    @Test
    public void paly() {
        System.out.println(judegGood.getKey());
    }

    @After
    public void tearDown() throws Exception {
    }
}