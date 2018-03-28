package Ex14;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*输入一个链表，输出该链表中倒数k个结点。*/
public class Solution14 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode FindKthToTail(ListNode head, int k) {
        Stack s = new Stack();
        if (head == null) {
            return null;
        }
        int count = 0;
        while (head != null) {
            s.push(head);
            head = head.next;
            count++;
        }
        if (k > count) {
            return null;
        }

        ListNode newNode = null;

        for (int i = 0; i < k; i++) {
            newNode = (ListNode) s.pop();
        }
        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        FindKthToTail(head, 5);


    }

}
