package Ex15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution15 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> s=new Stack<ListNode>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        ListNode newHead=s.pop();
        ListNode result=newHead;
        while (!s.isEmpty()){
            newHead.next=(ListNode)s.pop();
            newHead=newHead.next;
        }
        newHead.next=null;
        return result;
    }
    public static ListNode ReverseList_2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p1=head.next;
        ListNode p2=head.next;
        head.next=null;
        while(p2!=null){
            p2=p1.next;
            p1.next=head;
            head=p1;
            p1=p2;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        ListNode result=ReverseList_2(head);
        System.out.println(result.val);
        System.out.println(result.next.val);



    }
}
