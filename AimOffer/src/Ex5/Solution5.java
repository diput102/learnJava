package Ex5;

import java.util.Stack;

/**
 * time:20180325
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：栈（FILO）队列（FIFO） ：用两个栈，一个进去出来到第二个，再从第二个出来
 */
public class Solution5 {


    public static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        public Solution(){};

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }

            }
            return stack2.pop();
        }

    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

}

