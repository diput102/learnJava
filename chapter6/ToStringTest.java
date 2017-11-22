package chapter6;
class Apple
{
    private String color;
    private double weight;

    public Apple(){}
    //提供有参数的构造器
    public Apple (String color,double weight)
    {
        this.color=color;
        this.weight=weight;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String toString()
    {
        return"一个苹果颜色是"+color+"重量是"+weight;
    }
}
public class ToStringTest
{
    public static void main(String[] args)
    {
        Apple a=new Apple();
        System.out.println(a);
        Apple a2=new Apple("red",5);
        System.out.println(a2);
    }
}
