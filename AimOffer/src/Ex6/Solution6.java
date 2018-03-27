package Ex6;

/**
 * time：20180325
 * 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 知识点：二分法
 */
public class Solution6 {
    public static int minNumberInRotateArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid = -1;
        while (start <= end) {

            /*if (array[start] == array[end]&&start!=end) {
                for(int i=start;i<end;i++){
                    if(array[i]!=array[end]){
                        start=i;
                        break;
                    }
                }
            }*/
            if (array.length == 1) {
                break;
            }

            if (array[start + 1] == array[end]) {
                break;
            }
            mid = (start + end) / 2;
            if (array[mid] > array[end]) {
                start = mid;
            }
            if (array[mid] < array[end]) {
                end = mid;
            }
        }
        return array[end];

    }

    public static void main(String[] args) {
        int[] array = {5};
        System.out.println(minNumberInRotateArray(array));
    }
}
