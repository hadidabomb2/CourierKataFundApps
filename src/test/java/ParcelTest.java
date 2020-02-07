import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcelTest {

    @Test
    public void testingSmallParcelProperties(){
        Parcel parcel = new Parcel(1,1,1);
        assertEquals(parcel.getCost(), 3);
        assertEquals(parcel.getSize(), Sizes.SMALL);
    }
    @Test
    public void testingMediumParcelProperties(){
        Parcel parcel = new Parcel(10,10,1);
        assertEquals(parcel.getCost(), 8);
        assertEquals(parcel.getSize(), Sizes.MEDIUM);
    }
    @Test
    public void testingLargeParcelProperties(){
        Parcel parcel = new Parcel(50,5,50);
        assertEquals(parcel.getCost(), 15);
        assertEquals(parcel.getSize(), Sizes.LARGE);
    }
    @Test
    public void testingXLParcelProperties(){
        Parcel parcel = new Parcel(100,100,10);
        assertEquals(parcel.getCost(), 25);
        assertEquals(parcel.getSize(), Sizes.XL);
    }

}
