package Chapter8;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetTest2 {
    public static void main(String[] args){
        Collection c=new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);
        EnumSet enumSet= EnumSet.copyOf(c);
        System.out.println(enumSet);
        c.add("疯狂Java讲义");
        c.add("轻量级Java EE企业应用实战");
        System.out.println(c);
        //c里元素不是全部为枚举类
       // enumSet=EnumSet.copyOf(c);
    }
}
