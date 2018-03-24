package Ex4;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 参考网址：https://blog.csdn.net/leiflyy/article/details/51100687
 *https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
 * 二楼答案：前进的路上
 */
public class Solution4 {

    // Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 用于递归造树
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i ));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));

            }

        }
        return node;
    }
    //用来打印树
    public static void preTraverseBinTree(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val);
        if(node.left!=null){
            preTraverseBinTree(node.left);
        }
        if (node.right!=null){
            preTraverseBinTree(node.right);
        }
    }

    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        preTraverseBinTree(reConstructBinaryTree(pre,in));


    }

}
