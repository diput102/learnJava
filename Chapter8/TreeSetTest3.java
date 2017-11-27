package Chapter8;

import java.util.TreeSet;

class R1 implements Comparable{
    int count;
    public R1(int count){
        this.count=count;
    }
    public String toString(){
        return "R[count:"+count+"]";
    }
    //重写equals()方法，根据count来判断是否相等
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null&&obj.getClass()==R1.class){
            R1 r=(R1)obj;
            return r.count==this.count;
        }
        return false;
    }
    //重写compareTo（）方法，根据count大小来比较
    public int compareTo(Object obj){
        R1 r=(R1)obj;
        return count>r.count?1:
                count<r.count?-1:0;
    }
}
public class TreeSetTest3 {
    public static void main(String[] args){
        TreeSet ts=new TreeSet();
        ts.add(new R1(5));
        ts.add(new R1(-3));
        ts.add(new R1(9));
        ts.add(new R1(-2));
        //打印TreeSet集合，集合元素是有序排列的
        System.out.println(ts);
        //取出第一个元素
        R1 first=(R1)ts.first();
        //对第一个元素的count赋值
        first.count=20;
        //取出最后一个元素
        R1 last=(R1)ts.last();
        //对最后一个元素的count赋值，与第二个元素的count相同
        last.count=-2;
        System.out.println(ts);
        System.out.println(ts.remove(new R1(-2)));
        System.out.println(ts);
        System.out.println(ts.remove(new R1(5)));
        System.out.println(ts);
    }
}
