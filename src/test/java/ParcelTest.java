import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcelTest {

    @Test
    public void testingSmallParcelProperties(){
        Parcel parcel = new Parcel(1,1,1, 1);
        assertEquals(parcel.getCost(), 3);
        assertEquals(parcel.getType(), Types.SMALL);
    }
    @Test
    public void testingMediumParcelProperties(){
        Parcel parcel = new Parcel(10,10,1, 1);
        assertEquals(parcel.getCost(), 8);
        assertEquals(parcel.getType(), Types.MEDIUM);
    }
    @Test
    public void testingLargeParcelProperties(){
        Parcel parcel = new Parcel(50,5,50, 1);
        assertEquals(parcel.getCost(), 15);
        assertEquals(parcel.getType(), Types.LARGE);
    }
    @Test
    public void testingXLParcelProperties(){
        Parcel parcel = new Parcel(100,100,10, 1);
        assertEquals(parcel.getCost(), 25);
        assertEquals(parcel.getType(), Types.XL);
    }
    @Test
    public void testingForUnderWeightParcel(){
        Parcel parcel = new Parcel(10,10,10,1);
        assertEquals(parcel.getCost(), 8);
    }
    @Test
    public void testingForExactWeightOnLimitParcel(){
        Parcel parcel = new Parcel(10,10,10,3);
        assertEquals(parcel.getCost(), 8);
    }
    @Test
    public void testingForOverWeightParcel(){
        Parcel parcel = new Parcel(10,10,10,5.5);
        assertEquals(parcel.getCost(), 14);
    }

}
