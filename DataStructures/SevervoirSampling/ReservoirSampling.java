package DataStructures.SevervoirSampling;


import java.util.Arrays;
import java.util.Random;
/**
 * 蓄水池问题Reservoir sampling
 * 实例应用：
 *
 * 题目：给定一个数据流，其中包含无穷尽的搜索关键字（比如，人们在谷歌搜索时不断输入的关键字）。
 * 如何才能从这个无穷尽的流中随机的选取1000个关键字？
 * http://bylijinnan.iteye.com/blog/1468985
**/
public class ReservoirSampling {
    public static void main(String[] args){
        int k=10;
        int n=1000;
        int[] data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=i;
        }
        int[] sample=reservoirSampling(data,k);
        System.out.println(Arrays.toString(sample));
    }

    private static int[] reservoirSampling(int[] data, int k) {
        if(data==null){
            return new int[0];
        }
        if(data.length<k){
            return new int[0];
        }
        int[] sample=new int[k];
        int n=data.length;
        for(int i=0;i<n;i++) {
            if (i < k) {
                sample[i]=data[i];
            }
            else{
                int j= new Random().nextInt(i);
                if(j<k) {
                    sample[j] = data[i];
                }
            }
        }
        return sample;
    }

}
