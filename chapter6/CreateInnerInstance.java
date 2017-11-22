package chapter6;
class Out
{
    class In
    {
        public In(String msg)
        {
            System.out.println(msg);
        }
    }
}
public class CreateInnerInstance
{
    public static void main(String[] args)
    {
        Out.In in=new Out().new In("test message");
        //相当于以下三步
        //在外部类以外定义内部类变量
        //Out.In in;
        //new 外部类实例，其中包含了内部类实例
        //Out out=new Out();
        //通过外部类实例和内部类构造器创建非静态内部类实例
        //in=out.new In("test message");
        System.out.println();
    }
}
