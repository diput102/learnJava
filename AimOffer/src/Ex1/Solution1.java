package Ex1;

/**
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public static boolean Find(int target, int[][] array) {
        for(int i=array.length;i>0;i--){
            for(int j=0;j<array[i-1].length;j++){
                if(target>array[i-1][j]){
                }
                if(target<array[i-1][j]){
                    break;
                }
                if(target==array[i-1][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target=1;
        System.out.println(Find(target,array));
    }
}
