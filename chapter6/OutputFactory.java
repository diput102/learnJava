package chapter6;

public class OutputFactory
{
    public Output getOutput()
    {
        return new Printer();
    }
    public static void main(String[] args)
    {
        OutputFactory of=new OutputFactory();
        Computer c=new Computer(of.getOutput());
        c.keyIn("轻量级JavaEE企业应用实战");
        c.keyIn("疯狂JAVA讲义");
        c.keyIn("疯狂JAVA讲义2");
        c.print();
    }
}
