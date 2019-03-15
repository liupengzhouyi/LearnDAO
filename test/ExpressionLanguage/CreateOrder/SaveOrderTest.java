package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.Registered.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaveOrderTest {

    private Order order = null;

    private SaveOrder saveOrder = null;

    @Before
    public void setUp() throws Exception {

        order = new Order();

        order.setGood_id(2);
        order.setUser_id(3);
        order.setGood_number(10);

        saveOrder = new SaveOrder(order);
    }

    @Test
    public void paly() {
        System.out.println(saveOrder.getKey());
    }
}