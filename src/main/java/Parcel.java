public class Parcel {
    private int cost;
    private Sizes size;
    private int height;
    private int width;
    private int length;
    private double weight;

    /*
    Constructor for parcel, takes in dimensions and weight of the parcel and assigns the cost and size accordingly.
     */
    public Parcel(int heightIn, int widthIn, int lengthIn, double weightIn){
        height = heightIn;
        width = widthIn;
        length = lengthIn;
        weight = weightIn;
        assignCostAndSize();
        checkWeight();
    }

    /*
    Method which checks the size and weight of the parcel and adjusts the costs if needed.
     */
    private void checkWeight(){
        if(size == Sizes.SMALL){
            updateCostWithWeight(1);
        }
        else if(size == Sizes.MEDIUM){
            updateCostWithWeight(3);
        }
        else if(size == Sizes.LARGE){
            updateCostWithWeight(6);
        }
        else{
            updateCostWithWeight(10);
        }
    }

    /*
    Method which calculates the difference of weight between the weight and desired weight of the parcel. Changes cost if needed.
     */
    private void updateCostWithWeight(double desiredWeight){
        int weightDifference = (int) Math.ceil(weight - desiredWeight);
        if(weight <= desiredWeight){
            //do nothing
        }
        else{
            cost = cost + (2 * weightDifference);
        }
    }

    /*
    Method assigns the cost and size of the parcel depending on the parcels dimensions.
     */
    private void assignCostAndSize(){
        int largestDimension = findLargestDimension();

        if(largestDimension < 10){
            cost = 3;
            size = Sizes.SMALL;
        }
        else if(largestDimension < 50){
            cost = 8;
            size = Sizes.MEDIUM;
        }
        else if(largestDimension < 100){
            cost = 15;
            size = Sizes.LARGE;
        }
        else{
            cost = 25;
            size = Sizes.XL;
        }
    }

    /*
    Method finds the largest dimension of the parcel and returns it.
     */
    private int findLargestDimension(){
        int largestDimension = height;
        if(width > largestDimension){
            largestDimension = width;
        }
        if(length > largestDimension){
            largestDimension = length;
        }
        return largestDimension;
    }

    /*
    Returns the size of the parcel.
     */
    public Sizes getSize(){
        return size;
    }

    /*
    Returns the cost of the parcel.
     */
    public int getCost(){
        return cost;
    }
}
