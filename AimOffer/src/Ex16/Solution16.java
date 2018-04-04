package Ex16;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //非递归方法
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1);
        list.next = null;
        ListNode result = list;
        ListNode p1 = list1;
        ListNode p2 = list2;
        if (p1 == null) {
            return list2;
        }
        if (p2 == null) {
            return list1;
        }
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                list.next = p1;
                list = p1;
                p1 = p1.next;
            }
            if (p1 == null) {
                list.next = p2;
                break;
            }
            if (p1.val > p2.val) {
                list.next = p2;
                list = p2;
                p2 = p2.next;
            }
            if (p2 == null) {
                list.next = p1;
                break;
            }

        }

        return result.next;
    }

    //递归方法
    public static ListNode Merge_DG(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            head = list1;
            head.next = Merge_DG(list1.next, list2);
        }
        if (list1.val > list2.val) {
            head = list2;
            head.next = Merge_DG(list1, list2.next);
        }


        return head;

    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = Merge_DG(list1, list2);
        System.out.println(result.val);
        System.out.println(result.next.val);

    }
}



