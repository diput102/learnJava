package Ex9;

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解法：
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + 1
 * f(n-1)= f(n-2) + f(n-3) + ... + f(n-(n-1)) + 1
 * f(n)=2f(n-1)
 */
public class Solution9 {
    public static int JumpFloorII(int target) {
        int count=0;
        if(target==1){
            count= 1;
        }
        if(target==2){
            count= 2;
        }
        if(target>2){
            count=2*JumpFloorII(target-1);
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(JumpFloorII(4));
    }
}
