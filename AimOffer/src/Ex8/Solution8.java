package Ex8;

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 对于本题,前提只有 一次 1阶或者2阶的跳法。
 * <p>
 * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 * <p>
 * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 * <p>
 * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
 * 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，
 * 另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6，其他的不能从3跳到6的
 * <p>
 * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
 * <p>
 * e.可以发现最终得出的是一个斐波那契数列：
 */
public class Solution8 {
    public static int JumpFloor(int target) {
        int Sum = 0;
        if (target == 1 ) {
            Sum = Sum + 1;
        }
        if(target==2){
            Sum=Sum+2;
        }
        if (target > 2) {
            Sum = JumpFloor(target - 1) + JumpFloor(target - 2);
        }
        return Sum;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}


