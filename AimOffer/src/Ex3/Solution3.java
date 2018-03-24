package Ex3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * solution:最简单的 用栈stack
 * stack的基本用法
 *s.push( element )：入栈
 *s.peek()：返回栈顶元素
 *s.pop()：返回栈顶元素，并移除
 *s.empty()：判断是否为空栈
 */
public class Solution3 {

    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode temp=listNode;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(0);
        System.out.println(printListFromTailToHead(listNode));


    }


}
