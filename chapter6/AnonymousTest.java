package chapter6;
interface Product2
{
    public abstract  double getPrice();
    public String getName();
}
public class AnonymousTest
{
   public void test(Product2 p)
   {
       System.out.println("购买了一个"+ p.getName()+",花掉了"+p.getPrice());
   }
   public static void main(String[] args)
   {
       AnonymousTest ta=new AnonymousTest();
       ta.test(new Product2()
       {
           public double getPrice()
           {
               return 567.8;
           }
           public String getName()
           {
               return "AGP显卡";
           }
       });
   }
}

