import java.io.UnsupportedEncodingException;
//实现一个按字节来截取字符串的子串的方法，功能类似于String的substring（）方法，要求按字节截取，一个英文字符当一个字节，一个中文字符当两个字节
public class byteSubString {
    public static String bSubstring(String s, int length) throws Exception {
        byte[] bytes=s.getBytes("Unicode");
        int n=0;//表示当前的字节数
        int i=2;//要截取的字节数，,由于上面生成的字节数组中前两个字节是标志位bytes[0]=-2,bytes[1]=-1从第三个字节开始
       //当n为输入length时，i为多少
        for(;i<bytes.length&&n<length;i++){
            //奇数位置，如3，5，7等，为UCS2编码中两个字节的第二个字节
            if(i%2==1)
            {
                n++;//在UCS2第二个字节时n+1
            }
            else
            {
                //当usc2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                if(bytes[i]!=0)
                {
                    n++;
                }
            }
        }
        //如果i为奇数时，则为一个字符的第二位byte，所以要处理成偶数
        if(i%2==1) {
            if (bytes[i - 1] != 0) {
                i = i - 1;
            }
            else
                i=i+1;
        }
        return new String(bytes,0,i,"Unicode");
    }
    public static void main(String[] args)throws Exception
    {
        byteSubString bS=new byteSubString();
        String s="a加b等于c，如果a等1、b等于2，那么c等3";
        System.out.println(bS.bSubstring(s,6));
    }
}
