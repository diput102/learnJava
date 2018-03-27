package Ex7;

/**
 * time:20180326
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * f(n)=f(n-1)+f(n-2)
 */
public class Solution7 {
    public static int Fibonacci(int n) {
        int Sum = 0;
        if (n == 1 || n == 2) {
            Sum = Sum + 1;
        }

        if (n > 2) {
            Sum = Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return Sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
        ;
    }

}
