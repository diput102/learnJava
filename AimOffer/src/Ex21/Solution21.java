package Ex21;

import java.util.Stack;

/**
 * time:20180404
 * 题目：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 解法：
 * 用辅助栈对比
 * 相同就pop 不同就push
 * 再判空
 */
public class Solution21 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        //用来和出栈序列对比
        Stack<Integer> s = new Stack<>();
        if (popA.length != pushA.length) {
            return false;
        } else {
            int m = 0;
            for (int i = 0; i < pushA.length; i++) {
                s.push(pushA[i]);
                while (!s.empty()&&s.peek() == popA[m]) {
                    s.pop();
                    m++;
                }
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
