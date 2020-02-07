public class Order {

    private int totalCost;
    private Parcel parcel;
    private boolean speedyShipping;
    private String output;

    public Order(){
        speedyShipping = false;
    }

    public void makeParcel(int heightIn, int widthIn, int lengthIn){
        parcel = new Parcel(heightIn, widthIn, lengthIn);
        totalCost = parcel.getCost();
    }

    public void toggleSpeedyShipping(){
        speedyShipping = !speedyShipping;
    }

    public String finishOrder(){
        output = "Cost of parcel: " + totalCost + ". ";
        checkForSpeedyShipping();
        output += "Total cost: " + totalCost + ".";
        return output;
    }

    private void checkForSpeedyShipping(){
        if(speedyShipping){
            output += "Cost of speedy shipping: " + totalCost + ". ";
            totalCost = totalCost * 2;
        }
    }

    public int getTotalCost(){
        return totalCost;
    }
}
