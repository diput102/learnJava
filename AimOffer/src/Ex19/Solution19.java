package Ex19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * time:20180404
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 解法：本题采取记录最外圈四个角的位置方法，
 * 当满足左右间距大于1，上下间距大于1时，每次剥下一圈，将四个角都往内移一位，再判断是否满足条件；
 * 当不满足上述条件时，判断是一行或者一列或者单独一个元素，将该行、该列、该元素加入List。
 */
public class Solution19 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix != null) {
            //四个角的位置，用来变方向
            int left = 0;
            int right = matrix[0].length - 1;
            int top = 0;
            int bottom = matrix.length - 1;
            while ((right > left) && (bottom > top)) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                //把top行遍历完了，top指向下一行，其他同理
                top++;
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            //只剩一行
            if ((top == bottom) && (left < right)) {
                //从右往左遍历
                if (matrix.length % 2 == 0) {
                    for (int i = right; i <= left; i--) {
                        list.add(matrix[top][i]);
                    }
                }
                //从左往右遍历
                else {
                    for (int i = left; i <= right; i++) {
                        list.add(matrix[top][i]);
                    }
                }
            }
            //只剩一列
            if ((left == right) && (top < bottom)) {
                //从下往上遍历
                if (matrix[0].length % 2 == 0) {
                    for (int i = bottom; i >= top; i--) {
                        list.add(matrix[i][left]);
                    }
                }
                //从上往下遍历
                else {
                    for (int i = top; i <= bottom; i++) {
                        list.add(matrix[i][left]);
                    }

                }
            }
            //只剩一个元素
            if ((left == right) && (top == bottom)) {
                list.add(matrix[top][left]);
            }
        } else {
            list = null;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = null;
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
