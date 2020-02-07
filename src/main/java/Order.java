public class Order {

    private int totalCost;
    private Parcel parcel;
    private boolean speedyShipping;

    public Order(){
        speedyShipping = false;
    }

    public void makeParcel(int heightIn, int widthIn, int lengthIn){
        parcel = new Parcel(heightIn, widthIn, lengthIn);
        totalCost = parcel.getCost();
    }

    public void makeSpeedyShipping(){
        speedyShipping = true;
        totalCost = totalCost * 2;
    }

    public int getTotalCost(){
        return totalCost;
    }
}
