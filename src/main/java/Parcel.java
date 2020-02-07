public class Parcel {
    private int cost;
    private Sizes size;
    private int height;
    private int width;
    private int length;

    /*
    Constructor for parcel, takes in dimensions of the parcel and assigns the cost and size accordingly.
     */
    public Parcel(int heightIn, int widthIn, int lengthIn){
        height = heightIn;
        width = widthIn;
        length = lengthIn;
        assignCostAndSize();
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
