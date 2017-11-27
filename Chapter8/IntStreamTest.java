package Chapter8;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args){
        IntStream is= IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        //下面调用聚集方法的代码每次只能执行一行
//        System.out.println("最大值"+is.max().getAsInt());
//        System.out.println("最小值"+is.min().getAsInt());
//        System.out.println("总和"+is.sum());
//        System.out.println("总数"+is.count());
//        System.out.println("平均值"+is.average());
//        System.out.println("所有元素平方是否都大于20"+is.allMatch(ele->ele*ele>20));
//        System.out.println("是否任何元素平方是否都大于20"+is.anyMatch(ele->ele*ele>20));
        IntStream newIs=is.map(ele->ele*2+1);
        newIs.forEach(System.out::println);
    }
}
