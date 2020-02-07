import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class Order {

    private int totalCost;
    private ArrayList<Parcel> parcels;
    private ArrayList<Parcel> discountParcels;
    private boolean speedyShipping;
    private String output;

    /*
    Constructor for Order class. Speedy shipping is set to false by default.
     */
    public Order(){
        speedyShipping = false;
        parcels = new ArrayList<>();
    }

    /*
    Method to make the parcel in the order.
     */
    public void makeParcel(int heightIn, int widthIn, int lengthIn, double weightIn){
        Parcel parcel = new Parcel(heightIn, widthIn, lengthIn, weightIn);
        parcels.add(parcel);
        totalCost += parcel.getCost();
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
        checkForDiscounts();
        checkForSpeedyShipping();
        output += "Total cost: " + totalCost + ".";
        return output;
    }

    /*
    Method that checks for any discounts available. Will continue to loop if a discount was found.
     */
    private void checkForDiscounts(){
        discountParcels = new ArrayList<Parcel>(parcels);
        int startingTotalCost = totalCost;
        sortParcelDiscountByCost();

        while(true) {
            boolean smallDiscountAvailable = checkForSmallParcelDiscounts();
            boolean mediumDiscountAvailable = checkForMediumParcelDiscounts();
            boolean mixedDiscountAvailable = checkForMixedParcelDiscounts();
            boolean discountApplied = applyHighestDiscount(smallDiscountAvailable, mediumDiscountAvailable, mixedDiscountAvailable);
            if(!discountApplied){
                break;
            }
        }

        if(totalCost == startingTotalCost){
            //do nothing
        }
        else{
            output += ("Cost of discounts: " + (totalCost - startingTotalCost) + ". ");
        }

    }

    /*
    Helper method for checkForDiscounts(), finds and applies the highest discount
     */
    private boolean applyHighestDiscount(boolean smallDiscountAvailable, boolean mediumDiscountAvailable, boolean mixedDiscountAvailable){
        boolean discountApplied = false;
        int discountCost = -1;
        String biggestDiscount = "";

        if(smallDiscountAvailable){
            int smallCost = discountParcels.get(3).getCost();
            if(discountCost < smallCost){
                discountCost = smallCost;
                biggestDiscount = "Small";
            }
        }
        if(mediumDiscountAvailable){
            int mediumCost = discountParcels.get(2).getCost();
            if(discountCost < mediumCost){
                discountCost = mediumCost;
                biggestDiscount = "Medium";
            }
        }
        if(mixedDiscountAvailable){
            int mixedCost = discountParcels.get(4).getCost();
            if(discountCost < mixedCost){
                discountCost = mixedCost;
                biggestDiscount = "Mixed";
            }
        }

        if(biggestDiscount.equals("")){
            return discountApplied;
        }
        else if(biggestDiscount.equals("Small")){
            discountApplied = true;

            totalCost = totalCost - discountCost;

            for(int i=0; i<4; ++i) {
                discountParcels.remove(0);
            }

            return discountApplied;
        }
        else if(biggestDiscount.equals("Medium")){
            discountApplied = true;

            totalCost = totalCost - discountCost;

            for(int i=0; i<3; ++i) {
                discountParcels.remove(0);
            }

            return discountApplied;
        }
        else{
            discountApplied = true;

            totalCost = totalCost - discountCost;

            for(int i=0; i<5; ++i) {
                discountParcels.remove(0);
            }

            return discountApplied;
        }
    }

    /*
    Helper method for checkForDiscounts(), sorts parcels by cost.
     */
    private void sortParcelDiscountByCost(){
        sort(discountParcels);
    }

    /*
    Helper method for checkForDiscounts(), finds first small parcel discount.
     */
    private boolean checkForSmallParcelDiscounts(){
        boolean smallDiscountAvailable = false;
        int count = 0;
        for(int i = 0; i<discountParcels.size(); ++i){
            if(discountParcels.get(i).getType() == Types.SMALL){
                ++count;
            }
            if(count >= 4){
                smallDiscountAvailable = true;
                break;
            }
        }
        return smallDiscountAvailable;
    }

    /*
    Helper method for checkForDiscounts(), finds first medium parcel discount.
     */
    private boolean checkForMediumParcelDiscounts(){
        boolean mediumDiscountAvailable = false;
        int count = 0;
        for(int i = 0; i<discountParcels.size(); ++i){
            if(discountParcels.get(i).getType() == Types.MEDIUM){
                ++count;
            }
            if(count >= 3){
                mediumDiscountAvailable = true;
                break;
            }
        }
        return mediumDiscountAvailable;
    }

    /*
    Helper method for checkForDiscounts(), finds first mixed parcel discount.
     */
    private boolean checkForMixedParcelDiscounts(){
        boolean mixedDiscountAvailable = false;
        if(discountParcels.size() >= 5){
            mixedDiscountAvailable = true;
        }
        return mixedDiscountAvailable;
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
