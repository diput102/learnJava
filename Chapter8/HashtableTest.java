package Chapter8;

import java.util.Hashtable;

class A2{
    int count;
    public A2(int count){
        this.count=count;
    }
    //根据count的值来判断两个对象是否相等
    public boolean equals(Object obj){
        if(obj==this)
            return true;
        if(obj!=null&&obj.getClass()==A2.class){
            A2 a=(A2) obj;
            return(a.count==this.count);
        }
        return false;
    }
    //根据count来计算hashCode的值
    //有这个 new的对象hashCode就相等 就可以删除 不然new的对象不能删除对应的对象
//    public int hashCode(){
//        return this.count;
//    }
}
class B2{
    //重写equals（）方法，B对象与任何对象通过equals()方法比较都返回true
    public boolean equals(Object obj){
        return true;
    }
}
public class HashtableTest {
    public static void main(String[] args){
        Hashtable ht=new Hashtable();
        ht.put(new A2(60000),"疯狂Java讲义");
        ht.put(new A2(87563),"轻量级Java EE企业应用实战");
        ht.put(new A2(1232),new B2());
        System.out.print(ht);
        System.out.println(ht.containsValue("测试字符串"));
        System.out.println(ht.containsKey(new A2(87563)));
        ht.remove(new A2(1232));
        System.out.println(ht);

    }
}
