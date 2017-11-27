package Chapter8;

import java.util.ArrayDeque;
//栈：先进后出
public class ArrayDequeStack {
    public static void main(String[] args){
        ArrayDeque stack=new ArrayDeque();
        stack.push("疯狂Java讲义");
        stack.push("轻量级Java EE企业应用实战");
        stack.push("疯狂iOS讲义");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
