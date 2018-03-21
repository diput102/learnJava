package DataStructures.KMP;

import java.util.Arrays;

/**
 * Knuth-Morris-Pratt 字符串查找算法，简称为 “KMP算法”，常用于在一个文本串S内查找一个模式串P 的出现位置.
 * 原理http://blog.csdn.net/v_july_v/article/details/7041827
 * 实现http://blog.csdn.net/christ1750/article/details/51259425
 * */
public class KMP {
    public static int kmp(String str,String dest,int[] next){
        for(int i=0, j=0;i<str.length();i++){
            /*当dest有前缀后缀相同的时候，不用重新匹配，i接着找，dest的j用next数组重新定位*/
            while(j>0&&str.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if(str.charAt(i)==dest.charAt(j)){
                j++;
            }
           /*dest完全匹配*/
            if(j==dest.length()){
                return i-j+1;
            }

        }
        return 0;
    }
    public static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;
        for (int m=1,n=0;m<dest.length();m++){
            while(n>0&&dest.charAt(m)!=dest.charAt(n)){
                n=next[n-1];
            }
            if(dest.charAt(m)==dest.charAt(n)){
                n++;
            }
            next[m]=n;
        }
        return next;
    }
    public static void main(String[] args){
        String a = "ababa";
        String b = "ssdfgasdbababa";
        int[] next=kmpNext(a);
        int index=kmp(b,a,next);
        System.out.println(index);
        System.out.println(Arrays.toString(next));

    }
}
