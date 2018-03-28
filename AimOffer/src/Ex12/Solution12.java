package Ex12;

/**
 * time:20180328
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 解法：二分查找
 */
public class Solution12 {
    public static double Power(double base, int exponent) {
        double result = 0.0;
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        if (exponent == 0) {
            result = 1;
        }
        if (exponent == 1) {
            result = base;
        }

        if (exponent >= 2) {
            if (exponent % 2 == 0) {
                result = Power(base, exponent / 2) * Power(base, exponent / 2);
            } else {
                result = Power(base, exponent / 2) * Power(base, exponent / 2) * base;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2.0, -3));
    }
}
