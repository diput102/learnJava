package Chapter8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorEach {
    public static void main(String[] args){
        Collection books=new HashSet();
        books.add("abcde");
        books.add("abcdefg");
        books.add("abcdefgh");
        books.add("abcdef");

        Iterator it= books.iterator();
        //使用Lambda表达式（目标类型是Comsumer）来遍历集合元素
        it.forEachRemaining((obj)->System.out.println("迭代集合元素"+obj));
    }
}
