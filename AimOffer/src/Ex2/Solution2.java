package Ex2;

/**
 * time:20180323
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Solution2 {
    public static String replaceSpace(StringBuffer str) {

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)==' '){
                str.setCharAt(i,'%');
                str.insert(i+1,'2');
                str.insert(i+2,'0');
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        StringBuffer str=new StringBuffer();
        str.append("we are happy");
        System.out.println(replaceSpace(str));
    }
}
