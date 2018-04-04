package Ex20;

import java.util.Stack;

/**
 * time:20180404
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 解法：
 * <p>
 * 思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数
 * 比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
 *        则min依次入栈，5,  4,  3，no,no, no, no, 1
 *  
 * no代表此次不如栈
 * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
 */
public class Solution20 {
    static Stack<Integer> data = new Stack<>();
    static Stack<Integer> min = new Stack<>();

    public static void push(int node) {
        data.push(node);
        if (min.empty()) {
            min.push(node);
        }
        if (data.peek() <= min.peek()) {
            min.push(node);
        }
    }

    public static void pop() {
        if(data.peek()==min.peek()){
        data.pop();
        min.pop();}
        else {data.pop();}

    }

    public static int top() {
        return data.peek();

    }

    public static int min() {
        return min.peek();
    }

    public static void main(String[] args) {

        push(3);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(2);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
    }
}
