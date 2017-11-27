package Chapter8;

import java.util.Collection;
import java.util.HashSet;

public class CollectionStream {
    public static void main(String[] args){
        Collection books=new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂iOS讲义"));
        books.add(new String("疯狂Ajax讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books.stream().filter(ele->((String)ele).contains("疯狂")).count());
        System.out.println(books.stream().filter(ele->((String)ele).contains("Java")).count());
        System.out.println(books.stream().filter(ele->((String)ele).length()>10).count());
        //先调用Collection对象的stream()方法将集合转换为Stream
        //再调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
        books.stream().mapToInt(ele->((String)ele).length()).forEach(System.out::print);
    }
}
