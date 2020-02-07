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
    @Test
    public void testingMediumDiscountFunctionality(){
        Order order = new Order();
        order.makeParcel(10,10,10,3);
        order.makeParcel(10,10,10,3);
        order.makeParcel(10,10,10,3);
        order.makeParcel(10,10,10,4);
        order.makeParcel(10,10,10,4);
        order.makeParcel(10,10,10,4);
        order.finishOrder();
        assertEquals(order.getTotalCost(), 36);
    }
    @Test
    public void testingSmallDiscountFunctionality(){
        Order order = new Order();
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,1);
        order.finishOrder();
        assertEquals(order.getTotalCost(), 12);
    }
    @Test
    public void testingMixedDiscountFunctionality(){
        Order order = new Order();
        order.makeParcel(10,10,10,3);
        order.makeParcel(10,10,10,3);
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,1);
        order.makeParcel(1,1,1,2);
        order.finishOrder();
        assertEquals(order.getTotalCost(), 24);
    }
}
