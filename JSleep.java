package AdrienArdraRamadhanJSleepMN;



public class JSleep
{
    // instance variables - replace the example below with your own
    public int getHotelID(){
        return 0;
    }
    public String getHotelName(){
        return "hotelName";
    }
    public boolean isDiscount(){
        return true;
    }
    public float getDiscountPercentage(int before, int after){
        float discountPercentage=0.0f;
        if(before < after){
            discountPercentage=0.0f;
        }else{
            discountPercentage=(float)(before-after)/before;
        }
        return discountPercentage;
    }
    public int getDiscountedPrice(){
        float discountedPrice;
        return 0;
    }
    public int getOriginalPrice(){
        float getOriginalPrice;
        return 0;
    }
    public float getAdminFeePercentage(){
        int originalPrice=0;
        return originalPrice;
    }
    
}
