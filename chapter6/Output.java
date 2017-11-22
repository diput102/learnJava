package chapter6;

public interface Output
{
    //接口里定义的成员变量只能是常量
    int MAX_CACHE_LINE=1;
    //接口里定义的普通方法只能是public的抽象方法
    void out();
    void getData(String msg);
    default void print(String...msgs)
    {
        for (String msg: msgs)
        {
            System.out.println(msg);
        }
    }
    default void test()
    {
        System.out.println("默认test（）方法");
    }
    //在接口中定义类方法，需要使用static 修饰
    static String staticTest()
    {
        return "接口里的类方法";
    }
}
