import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void testingMakeParcelFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1);
        assertEquals(order.getTotalCost(), 3);
    }
    @Test
    public void testingMakeOrderSpeedyShippingFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1);
        order.toggleSpeedyShipping();
        order.finishOrder();
        assertEquals(order.getTotalCost(), 6);
    }
}
