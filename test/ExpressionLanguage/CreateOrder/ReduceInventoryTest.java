package ExpressionLanguage.CreateOrder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReduceInventoryTest {

    private ReduceInventory reduceInventory = null;

    private Order order = null;

    @Before
    public void setUp() throws Exception {

        order = new Order();

        order.setUser_id(1);

        order.setGood_id(1);

        order.setGood_number(23);

        reduceInventory = new ReduceInventory(order);
    }

    @After
    public void tearDown() throws Exception {

        order = null;

        reduceInventory = null;

    }

    @Test
    public void getGetSQL() {

        System.out.println(this.getReduceInventory().getGetSQL());

    }

    @Test
    public void getSaveSQL() {

        System.out.println(this.getReduceInventory().getSaveSQL());

    }

    @Test
    public void getOrdOrder() {

        System.out.println(this.getReduceInventory().getOrder().getGood_number());

    }

    @Test
    public void updateNewGoodNumber() {

        System.out.println(this.getReduceInventory().isKey());

    }

    public ReduceInventory getReduceInventory() {
        return reduceInventory;
    }

    public void setReduceInventory(ReduceInventory reduceInventory) {
        this.reduceInventory = reduceInventory;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}