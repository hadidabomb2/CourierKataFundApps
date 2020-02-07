public class Order {

    private int totalCost;
    private Parcel parcel;
    private boolean speedyShipping;
    private String output;

    /*
    Constructor for Order class. Speedy shipping is set to false by default.
     */
    public Order(){
        speedyShipping = false;
    }

    /*
    Method to make the parcel in the order.
     */
    public void makeParcel(int heightIn, int widthIn, int lengthIn, double weightIn){
        parcel = new Parcel(heightIn, widthIn, lengthIn, weightIn);
        totalCost = parcel.getCost();
    }

    /*
    Method to toggle the speedyShipping boolean value. If true, set to false, if false, set to true.
     */
    public void toggleSpeedyShipping(){
        speedyShipping = !speedyShipping;
    }

    /*
    Method to construct output and also check if speedy shipping is true or false. If true, will add to output and change cost.
     */
    public String finishOrder(){
        output = "Cost of parcel: " + totalCost + ". ";
        checkForSpeedyShipping();
        output += "Total cost: " + totalCost + ".";
        return output;
    }

    /*
    If speedy shipping is true, update output and cost.
     */
    private void checkForSpeedyShipping(){
        if(speedyShipping){
            output += "Cost of speedy shipping: " + totalCost + ". ";
            totalCost = totalCost * 2;
        }
    }

    /*
    Returns the total cost of the order.
     */
    public int getTotalCost(){
        return totalCost;
    }
}
