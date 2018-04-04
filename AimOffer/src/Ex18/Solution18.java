package Ex18;

import java.util.Arrays;

/*操作给定的二叉树，将其变换为源二叉树的镜像。*/
public class Solution18 {

     public static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public static void Mirror(TreeNode root) {
         if(root!=null){
             TreeNode temp=root.left;
             root.left=root.right;
             root.right=temp;
             if(root.left!=null){
                 Mirror(root.left);
             }
             if(root.right!=null){
                 Mirror(root.right);
             }
         }

    }
    public static void PrintTree(TreeNode root){
         if(root!=null) {
             System.out.println(root.val + " ");
             PrintTree(root.left);
             PrintTree(root.right);
         }

    }
    public static void main(String[] args){
         TreeNode root=new TreeNode(0);
         root.left=new TreeNode(1);
         root.left.left=new TreeNode(2);
         root.right=new TreeNode(3);
         TreeNode root1=null;
         PrintTree(root);
         Mirror(root1);
         PrintTree(root1);
    }

}
