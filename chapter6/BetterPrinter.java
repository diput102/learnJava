package chapter6;

public class BetterPrinter implements Output
{
    private String[] printData=new String[MAX_CACHE_LINE*2];
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
        if(dataNum>=MAX_CACHE_LINE*2)
        {
            System.out.println("输出队列已满，添加失败");
        }
        else
        {
            //把打印数据添加到队伍里，已保存数据的数量加1
            printData[dataNum++]=msg;
        }
    }
}
