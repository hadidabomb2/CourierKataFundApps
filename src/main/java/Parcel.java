public class Parcel implements Comparable<Parcel> {
    private int cost;
    private Types type;
    private int height;
    private int width;
    private int length;
    private double weight;

    /*
    Constructor for parcel, takes in dimensions and weight of the parcel and assigns the cost and type accordingly.
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
    Method which checks the type and weight of the parcel and adjusts the costs if needed.
     */
    private void checkWeight(){
        if(weight > 22){
            type = Types.HEAVY;
            cost = 50;
            updateCostWithWeight(50, 1);
        }
        else if(type == Types.SMALL){
            updateCostWithWeight(1, 2);
        }
        else if(type == Types.MEDIUM){
            updateCostWithWeight(3, 2);
        }
        else if(type == Types.LARGE){
            updateCostWithWeight(6, 2);
        }
        else{
            updateCostWithWeight(10, 2);
        }
    }

    /*
    Method which calculates the difference of weight between the weight and desired weight of the parcel. Changes cost if needed.
     */
    private void updateCostWithWeight(double desiredWeight, int increasingAmount){
        int weightDifference = (int) Math.ceil(weight - desiredWeight);
        if(weight <= desiredWeight){
            //do nothing
        }
        else{
            cost = cost + (increasingAmount * weightDifference);
        }
    }

    /*
    Method assigns the cost and type of the parcel depending on the parcels dimensions.
     */
    private void assignCostAndSize(){
        int largestDimension = findLargestDimension();

        if(largestDimension < 10){
            cost = 3;
            type = Types.SMALL;
        }
        else if(largestDimension < 50){
            cost = 8;
            type = Types.MEDIUM;
        }
        else if(largestDimension < 100){
            cost = 15;
            type = Types.LARGE;
        }
        else{
            cost = 25;
            type = Types.XL;
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
    Returns the type of the parcel.
     */
    public Types getType(){
        return type;
    }

    /*
    Returns the cost of the parcel.
     */
    public int getCost(){
        return cost;
    }

    /*
    Compares this parcel to another parcel by cost.
     */
    @Override
    public int compareTo(Parcel parcel) {
        if(this.getCost() < parcel.getCost()){
            return 1;
        }
        else if(this.getCost() > parcel.getCost()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
