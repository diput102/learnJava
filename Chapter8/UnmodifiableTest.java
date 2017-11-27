package Chapter8;

import java.util.*;

public class UnmodifiableTest {
    public static void main(String[] args){
        List unmodifiableList= Collections.emptyList();
        Set unmodifiableSet=Collections.singleton("疯狂Java讲义");
        Map scores=new HashMap();
        scores.put("语文",80);
        scores.put("Java",82);
        Map unmodifiableMap=Collections.unmodifiableMap(scores);
        unmodifiableList.add("测试元素");
        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("语文",90);
    }
}
