package DataStructures.RotateWord;

import java.util.Map;
import java.util.Set;

public class rotateWord {
    public static void main(String[] args){
        String str1="abc";
        String str2="bca";

        if(str1.length()!=str2.length()){
            System.out.println("false");
        }
        else{
            String str= str1.concat(str1);
            System.out.println(str.contains(str2));

        }
    }
}
