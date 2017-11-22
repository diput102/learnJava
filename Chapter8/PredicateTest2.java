package Chapter8;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args){
        Collection books=new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂iOS讲义"));
        books.add(new String("疯狂Ajax讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(calAll(books,ele->((String)ele).length()>10));
        System.out.println(calAll(books,ele->((String)ele).contains("疯狂")));
        System.out.println(calAll(books,ele->((String)ele).contains("Java")));
    }
    public static int calAll(Collection books,Predicate p){
        int total=0;
        for(Object obj:books){
            //使用Predicate 的test()方法判断对象是否满足Predicate指定的条件
            if(p.test(obj)){
                total++;
            }
        }
        return total;
    }
}
