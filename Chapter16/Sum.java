package Chapter16;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

 class CalTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD=20;
    private int start;
    private int end;
    private int[] arr;
    public CalTask(int start,int end,int[] arr){
        this.start=start;
        this.end=end;
        this.arr=arr;
    }
    @Override
    protected Integer compute(){
        int sum=0;
        if(end-start<=THRESHOLD){
            for(int i=start;i<end;i++){
                sum=sum+arr[i];
            }
            return sum;
        }
        else{
            int middle=(end+start)/2;
            CalTask left=new CalTask(start,middle,arr);
            CalTask rigth=new CalTask(middle,end,arr);
            left.fork();
            rigth.fork();
            return left.join()+rigth.join();
        }
    }
}
public class Sum{
     public static void main(String[] args)throws Exception{
         int[] arr=new int[100];
         Random rand=new Random();
         int total=0;
         for(int i=0,len=arr.length;i<len;i++){
             int tmp=rand.nextInt(20);
             total=total+(arr[i]=tmp);
         }
         System.out.println(total);
         ForkJoinPool pool=new ForkJoinPool();
         Future<Integer> future=pool.submit(new CalTask(0,arr.length,arr));
         System.out.println(future.get());
         pool.shutdown();

     }

}