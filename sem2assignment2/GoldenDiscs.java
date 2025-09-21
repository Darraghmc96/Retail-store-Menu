
/**
 * Write a description of class GoldenDiscs here.
 *
 * @author (Darragh mcmanus)
 * @version (a version number or a date)
 */
public class GoldenDiscs
{
   private double price;
   private int quantity;
   private String name;
   
    
    
    
   //blank object
   public GoldenDiscs()
   {
       this.price = 0;
       this.quantity = 0;
       this.name = "";
   }
   
   //object with data
   public GoldenDiscs(double price, int quantity, String name)
   {
       this.price = price;  
       this.quantity = quantity;
       this.name = name;
   }
   
   //getters
   public double getPrice()
   {
       return this.price;
    }
    
    public int getQuantity()
    {
        return this.quantity;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    //setters
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
      
    //toString
    public String toString()
    {
        return "price: " + this.price + "\n" + 
        "quantity: " + this.quantity + "\n" + 
        "name: " + this.name + "\n";
        
    }
    
   
}
