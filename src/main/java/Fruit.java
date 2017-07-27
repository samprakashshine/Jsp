public class Fruit {
    private String name;
    private Double price; 
  public  Fruit(String name,Double price){
        this.name = name;
        this.price = price ;
    }   
   public Fruit(){}    
        //getters, setters & constructor 

   // public void setName(String name)
   // {
    //    this.name=name;
   // }
    public String getName()
    {
        return name;
    }
   //  public void setPrice(Double price)
   // {
   //     this.price=price;
   // }
    public Double getPrice()
    {
        return price;
    }
}