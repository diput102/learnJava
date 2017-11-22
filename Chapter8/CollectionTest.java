package Chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
    public static void main(String[] args){
        Collection c=new ArrayList();
        //添加元素
        c.add("孙悟空");
        c.add(6);
        System.out.println("c集合的个数为"+c.size());
        //删除元素
        c.remove(6);
        System.out.println("c集合的个数为"+c.size());
        //判断是否包含字符串
        System.out.println("c集合是否包含\"孙悟空\"字符串"+c.contains("孙悟空"));
        c.add("abc");
        System.out.println("c集合的元素"+c);
        Collection books=new HashSet();
        books.add("bcefg");
        books.add("abc");
        System.out.println("c集合是否完全包含books集合"+c.containsAll(books));
        c.removeAll(books);
        System.out.println("c集合的元素"+c);
        //删除c集合里的所有元素
        c.clear();
        System.out.println("c集合的元素"+c);
        books.retainAll(c);
        System.out.println("books集合的元素"+books);

    }
}
