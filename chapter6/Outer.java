package chapter6;

public class Outer
{
    private int outProp=9;
    class Inner
    {
        private int inProp=5;
        public void acessOuterProp()
        {
            //非静态内部类可以直接访问外部类的private成员变量
            System.out.println(outProp);
        }
    }
    public void acessInnerProp()
    {
        System.out.println(new Inner().inProp);
    }
    public static void main(String[] args)
    {
        Outer ot=new Outer();
        ot.acessInnerProp();
    }
}
