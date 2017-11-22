package chapter6;
//1."拆成三个模块”是为了把方法传入另一个方法
//2.方法taste()传入方法eat()是为了满足需求，只传数据不能满足需求
//3.但是方法不能直接传方法，要通过接口Eatable()
//4.接口不能实现，要通过类，此处通过Lambda表达式
interface Eatable {
    void taste();
}
interface Flyable {
    void fly(String weather);
}
interface Addable {
    int add(int a,int b);
}
public class LambdaQs {
    //调用该方法需要Eatable对象
    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }
    //调用该方法需要Flyable对象
    public void drive(Flyable f) {
        System.out.println("我正在驾驶："+f);
        f.fly("【碧空如洗的晴日】");
    }
    //调用该方法需要Addable对象
    public void test(Addable add)
    {
        System.out.println("5+3="+add.add(5,3));
    }
    public static void main(String[] args)
    {
        LambdaQs lq=new LambdaQs();
        lq.eat(()-> {
            System.out.println("苹果味道不错");
        });
        lq.drive((weather)->
        {
            System.out.println("今天的天气是"+weather);
            System.out.println("直升机飞行平稳");
        });
        lq.test((a,b)->
        {
            return a+b;
        });

    }

}
