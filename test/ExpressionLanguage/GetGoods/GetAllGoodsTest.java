package ExpressionLanguage.GetGoods;

import ExpressionLanguage.AddGoods.Good;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GetAllGoodsTest {

    private GetAllGoods getAllGoods = null;

    @Before
    public void setUp() throws Exception {

        getAllGoods = new GetAllGoods();

    }

    @Test
    public void paly() {
        List<Good> list = getAllGoods.getListOfGoods();

        for (Good good:list
             ) {
            System.out.println("--------------");
            System.out.println(good.getGood_id());
            System.out.println(good.getGood_name());
            System.out.println(good.getGood_number());
            System.out.println(good.getGood_price());
            System.out.println("--------------");
        }
    }
}
