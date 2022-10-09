package AdrienArdraRamadhanJSleepMN;


/**
 * Write a description of class Voucher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Voucher extends Serializable implements FileParser 
{
   public Type type;
   public double cut;
   public String name;
   public int code;
   public double minimum;
   private boolean used;
   
   public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
       super(id);
       this.used = used;
       this.type = type;
       this.cut = cut;
       this.name = name;
       this.code = code;
       this.minimum = minimum;
   }
   public boolean canApply(Price price){
      
      if( price.price > minimum && this.used == false){
          return true;
      }
      else{
          return false;
      }
   }
   public double apply(Price price){
       this.used = true;
       
       if(this.type == Type.DISCOUNT){
           if(cut >= 100){
               cut = 100;
           }
           return price.price - (price.price * cut)/10;
       }
       else{
           if(cut >= price.price){
               cut = price.price;
           }
           return price.price-=cut;
       }
       
   }
   public boolean isUsed(){
       return (boolean) used;
   }
}
    
