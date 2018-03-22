package DataStructures.ReverseWord;

import java.util.Arrays;

/**
 * time:20180323
 * item:weak as fuck -fuck as weak
 * 参考网址：https://www.cnblogs.com/mfrank/p/7891512.html
 */

public class reverseWord {
    /*reverseAll是为了全体逆序 kaew sa kcuf*/
    public static char[] reverseAll(String str){
        /*要转换成字符数组才可以，不然没办法赋值*/
        char[] charArr=new char[str.length()];
        for(int i=str.length();i>0;i--){
            charArr[str.length()-i]=str.charAt(i-1);
        }

        return charArr;
    }
    /*该方法是将每个单词逆序*/
    public static char[] reversrPart(char[] sentence){
        /*m是提示空格位置的指针*/
        int m=0;
        char[] charArr=new char[sentence.length];
        for(int i=0;i<sentence.length;i++){
            if(sentence[i]==' '){
                for(int n=m;n<i;n++) {
                 charArr[n]=sentence[i-n+m-1];
                }
                charArr[i]=' ';
                 m=i+1;
            }
        }
        return charArr;
    }
    public static void main(String[] args){
        String str="weak   as    fuck";
        String strEnd=" ";
        String strAll=strEnd+str;
        System.out.println("原句"+str);
        char[] result;
        result=reverseAll(strAll);
        result=reversrPart(result);
        System.out.print("逆序后");
        System.out.print(result);
        /*String newStr=new String();
        newStr=reverseall(str);
        System.out.println(newStr);
*/
    }
}
