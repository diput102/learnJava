package chapter6;

public class AddCommand implements Command
{
    public void process(int[] target)
    {
        int sum=0;
        for(int tmp:target)
        {
            sum=sum+tmp;
        }
        System.out.println("数组元素的总和是"+sum);
    }
}
