package Chapter8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorErrorTest {
    public static void main(String[] arg)
    {
        //创建集合
        Collection books=new HashSet();
        books.add("abcde");
        books.add("abcdefgh");
        books.add("abcdef");
        books.add("abcdefg");
        Iterator it=books.iterator();
        while(it.hasNext()){
            String book=(String)it.next();
            System.out.println(book);
            if(book.equals("abcde")){
                //使用Iterator迭代过程中，不可修改集合元素，下面代码引发异常
                books.remove(book);
            }
        }
    }
}
