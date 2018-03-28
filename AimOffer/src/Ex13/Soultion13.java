package Ex13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 解法：
 * 1、冒泡
 * 2、用一个长度可变的链表
 */
public class Soultion13 {
    /*长度可变链表，涉及知识点
    1.如何把ArrayList变成int[]
    2.如何把Integer[]变成int[]*/
    public static void reOrderArray(int[] array) {
        ArrayList List = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                List.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                List.add(array[i]);
            }
        }
        Integer[] result = new Integer[List.size()];
        List.toArray(result);
        int[] resultInt=new int[result.length];
        for(int i=0;i<result.length;i++){
            resultInt[i]=result[i];
        }
        System.out.println(Arrays.toString(result));

    }
    /*冒泡算法*/
    public static void reOrderArray_MAOPAO(int[] array) {
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            for(int j=array.length-1;j>i;j--){
                if(array[j-1]%2==0&&array[j]%2!=0){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }

        }
        System.out.println(Arrays.toString(array));


    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray_MAOPAO(array);

    }
}
