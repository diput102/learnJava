package Ex17;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * time:20180403
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 链接：https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88
 * 来源：牛客网
 * <p>
 * 1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
 * 剩下的代码不会执行，如果匹配不成功，默认返回false
 * 2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
 * 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 * 再判断右子树和tree2是否相同
 * 3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 * DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
 * tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
 * （2）如果tree1为空，tree2为空，说明匹配。
 */
public class Solution17 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /*判断树是否相等*/

    public static boolean DoseTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;

        if (root2 == null)
            return true;

        if (root1.val != root2.val)
            return false;

        return DoseTree1HasTree2(root1.left, root2.left) && DoseTree1HasTree2(root1.right, root2.right);
    }

   /* 1设符号位，2遍历root1二叉树*/

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoseTree1HasTree2(root1, root2);
            }

            if (!result) {
                result=HasSubtree(root1.left, root2);
            }
            if (!result) {
                result=HasSubtree(root1.right, root2);
            }

        }

        return result;
    }

    public static void PrintTree(TreeNode root1) {

        if (root1!= null) {
            System.out.print(root1.val );
            PrintTree(root1.left);

            PrintTree(root1.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);

        root1.left.left = new TreeNode(9);
       /* root1.right.left = new TreeNode(5);*/
        root1.left.left.left = new TreeNode(2);
        root1.left.left.left.left = new TreeNode(5);
        /*root1.left.left.left = new TreeNode(6);*/
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.left.left= new TreeNode(2);

        System.out.println(HasSubtree(root1, root2));
        PrintTree(root2);

    }

}
