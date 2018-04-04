package Ex22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * time:20180404
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解法：
 * 借助一个队列
 * 利用队列先进先出来依次遍历root的左右
 */
public class Solution22 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;

    }

    public static void  main(String[] args){
        /*TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);*/
        TreeNode root=null;

        System.out.println(PrintFromTopToBottom(root));


    }

}
