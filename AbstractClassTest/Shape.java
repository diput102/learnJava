package chapter6.AbstractClassTest;

public abstract class Shape {
    {
        System.out.println("执行shape的初始化。。");
    }
    private String color;
    //定义一个计算周长的抽象方法
    public abstract double calPerimeter();
    //定义一个返回形状的抽象方法
    public abstract String getType();
    //定义Shape的构造器，该构造器并不是用于创建Shape对象
    public Shape(){}
    public Shape(String color) {
        System.out.println("执行Shape的构造器");
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
