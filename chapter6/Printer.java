package chapter6;
interface Product
{
    int getProduceTime();
}

public class Printer implements Output,Product
{
    private String[] printData=new String[MAX_CACHE_LINE];
    //用以记录当前需打印的作业数
    private int dataNum=0;
    public void out()
    {
        //只要还有作业，就继续打印
        while(dataNum>0)
        {
            System.out.println("打印机打印"+printData[0]);
            System.arraycopy(printData,1,printData,0,--dataNum);
        }
    }
    public void getData(String msg)
    {
        if(dataNum>=MAX_CACHE_LINE)
        {
            System.out.println("输出队列已满，添加失败");
        }
        else
        {
            //把打印数据添加到队伍里，已保存数据的数量加1
            printData[dataNum++]=msg;
        }
    }
    public int getProduceTime()
    {
        return 45;
    }
    public static void main(String[] args)
    {
        //创建一个Printer对象，当成Output使用
        Output o=new Printer();
        o.getData("轻量级JavaEE企业应用实战");
        o.getData("疯狂JAVA讲义");
        o.out();
        //调用Output接口中定义的默认方法
        o.print("sunwukong","zhubajie","baigujing");
        o.test();
        System.out.println(Output.staticTest());
        //创建一个Printer对象，当成Product使用
        Product p=new Printer();
        System.out.println(p.getProduceTime());
        Object obj=p;
    }
}
