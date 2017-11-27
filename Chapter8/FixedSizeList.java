package Chapter8;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {
    public static void main(String[] args){
        List fixedList= Arrays.asList("疯狂Java讲义","轻量级Java EE企业应用实战");
        //获取fixedList的实现类，将输出Arrays$ArrayList
        System.out.println(fixedList.getClass());
        //使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);
        //增加删除元素都会引发异常
        fixedList.add("Android");
        fixedList.remove("疯狂Java讲义");
    }
}
