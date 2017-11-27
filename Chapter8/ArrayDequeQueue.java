package Chapter8;

import java.util.ArrayDeque;
//队列:先进先出
public class ArrayDequeQueue {
    public static void main(String[] args){
        ArrayDeque queue=new ArrayDeque();
        queue.offer("疯狂Java讲义");
        queue.offer("轻量级Java EE企业应用实战");
        queue.offer("疯狂iOS讲义");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
