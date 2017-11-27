package Chapter8;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args){
        TreeSet nums=new TreeSet();
        //向TreeSet中添加四个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        //输出集合元素，看到集合元素已经处于排序状态
        System.out.println(nums);
        System.out.println(nums.first());
        System.out.println(nums.last());
        System.out.println(nums.headSet(4));
        System.out.println(nums.tailSet(5));
        System.out.println(nums.subSet(-3,4));
    }
}
