import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void testingMakeParcelFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1, 1);
        assertEquals(order.getTotalCost(), 3);
    }

    @Test
    public void testingFinishOrderFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1, 1);
        String output = order.finishOrder();
        assertEquals(output, "Cost of parcel: 3. Total cost: 3.");
    }
    @Test
    public void testingMakeOrderSpeedyShippingFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1, 1);
        order.toggleSpeedyShipping();
        String output = order.finishOrder();
        assertEquals(output, "Cost of parcel: 3. Cost of speedy shipping: 3. Total cost: 6.");
        assertEquals(order.getTotalCost(), 6);
    }
}
