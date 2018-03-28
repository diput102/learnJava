package Ex10;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution10 {
    public int RectCover(int target) {
        int count = 1;
        if (target == 1) {
            count = 1;
        }
        if (target == 2) {
            count = 2;
        }
        if (target > 2) {
            count = RectCover(target - 1) + RectCover(target - 2);
        }
        return count;

    }
}
