package ExpressionLanguage.CreateOrder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeOrderTest {

    private Order order = null;

    private JudgeOrder judgeOrder = null;

    @Before
    public void setUp() throws Exception {
        order = new Order();
        order.setGood_number(-1);
        order.setGood_id(1);
        order.setUser_id(1);
        judgeOrder = new JudgeOrder(order);
    }

    @Test
    public void paly() {
        System.out.println(judgeOrder.getKey());
    }
}