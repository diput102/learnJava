package Chapter8;

import java.util.ArrayList;
import java.util.List;

class A1{
    public boolean equals(Object obj){
        return true;
    }
}
public class ListTest2 {
    public static void main(String[] arg){
        List books=new ArrayList();
        books.add(new String("轻量级 Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books);
        books.remove(new A());
        System.out.println(books);
        books.remove(new A());
        System.out.println(books);
    }
}
