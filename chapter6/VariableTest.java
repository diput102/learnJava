package chapter6;

public class VariableTest {
    //定义成员变量时指定默认值
    final int a=6;
    //在构造器和初始化块中分配初始值
    final String str;
    final int c;
    final static double d;
   // final char ch;
    //初始化块中为实例变量指定初始值
    {
        str="Hello";
    }
    //静态初始化块
    static
    {
       d=5.6;
    }
    //构造器
    public VariableTest()
    {
        c=5;
    }
    public void changeFinal()
    {
        //d=1.2;
      // ch='2';
    }
    public static void main(String[] args)
    {
        VariableTest ft=new VariableTest();
        System.out.println(ft.a);
        System.out.println(ft.c);
        System.out.println(ft.d);
    }

}
