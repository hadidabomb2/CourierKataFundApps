public class Parcel {
    private int cost;
    private Sizes size;
    private int height;
    private int width;
    private int length;

    public Parcel(int heightIn, int widthIn, int lengthIn){
        height = heightIn;
        width = widthIn;
        length = lengthIn;
        assignCostAndSize();
    }

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

    public Sizes getSize(){
        return size;
    }

    public int getCost(){
        return cost;
    }
}
