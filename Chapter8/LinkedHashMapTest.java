package Chapter8;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args){
        LinkedHashMap scores=new LinkedHashMap();
        scores.put("yuwen",80);
        scores.put("shuxue",90);
        scores.put("yingyu",100);
        scores.forEach((key,value)->System.out.println(key+"---->"+value));
    }
}
