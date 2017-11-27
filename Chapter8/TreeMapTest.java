package Chapter8;

import java.util.TreeMap;

class R2 implements Comparable{
    int count;
    public R2(int count){
        this.count=count;
    }
    public String toString(){
        return "R[count:"+count+"]";
    }
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj!=null&&obj.getClass()==R2.class){
            R2 r=(R2)obj;
            return(r.count==this.count);
        }
        return false;
    }
    public int compareTo(Object obj){
        R2 r=(R2)obj;
        return count>r.count?1:
                count<r.count?-1:0;
    }
}
public class TreeMapTest {
    public static void main(String[] args){
        TreeMap tm=new TreeMap();
        tm.put(new R2(3),"轻量级Java EE企业应用实战");
        tm.put(new R2(-5),"疯狂Java讲义");
        tm.put(new R2(9),"疯狂Android讲义");
        System.out.println(tm);
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastKey());
        System.out.println(tm.higherKey(new R2(2)));
        System.out.println(tm.lowerEntry(new R2(2)));
        System.out.println(tm.subMap(new R2(-1),new R2(4)));

    }
}
