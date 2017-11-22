package chapter6.ChapterTask;

public abstract class Car
{
    {
        System.out.println("这是抽象类Car的初始化模块");
    }
    private int heavy;
    private String use;
    private int wheelRadius;
    public abstract String getType();
    public int getWheelRadius() {
        return wheelRadius;
    }
    public Car(){}
    public Car(int heavy,String use)
    {
        System.out.println("执行car有参构造器");
        this.heavy=heavy;
        this.use=use;
    }
}
