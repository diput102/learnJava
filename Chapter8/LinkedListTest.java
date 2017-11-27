package Chapter8;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args){
        LinkedList books=new LinkedList();
        books.offer("疯狂Java讲义");
        books.push("轻量级Java EE企业应用实战");//push到双端队列的栈的栈顶
        books.offerFirst("疯狂Android讲义");//插入双端队列开头
        for(int i=0;i<books.size();i++){
            System.out.println("遍历中："+books.get(i));
        }
        System.out.println(books.peek());
        System.out.println(books.peekLast());
        System.out.println(books.pop());
        System.out.println(books);
        System.out.println(books.pollLast());
        System.out.println(books);
    }
}
