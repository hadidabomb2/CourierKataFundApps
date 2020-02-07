public class Parcel {
    private int cost;
    private String size;
    private int height;
    private int width;
    private int length;

    public Parcel(int heightIn, int widthIn, int lengthIn){
        height = heightIn;
        width = widthIn;
        length = lengthIn;

        int largestDimension = height;
        if(width > largestDimension){
            largestDimension = width;
        }
        if(length > largestDimension){
            largestDimension = length;
        }
        if(largestDimension < 10){
            cost = 3;
            size = "Small";
        }
        else if(largestDimension < 50){
            cost = 8;
            size = "Medium";
        }
        else if(largestDimension < 100){
            cost = 15;
            size = "Large";
        }
        else{
            cost = 25;
            size = "XL";
        }
    }

    public String getSize(){
        return size;
    }

    public int getCost(){
        return cost;
    }
}
