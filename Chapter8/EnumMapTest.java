package Chapter8;

import java.util.EnumMap;

enum Season1{
    SPRING,SUMMER,FALL,WINTER
}
public class EnumMapTest {
    public static void main(String[] args){
        EnumMap enumMap=new EnumMap(Season1.class);
        enumMap.put(Season1.SUMMER,"夏日炎炎");
        enumMap.put(Season1.SPRING,"春暖花开");
        System.out.println(enumMap);
    }
}
