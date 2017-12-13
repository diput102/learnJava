package Chapter15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(String[] args){
        String src="aaaaaaaaaa\n"
                +"bbbbbbbbbbbbb\r\n"
                +"cccccccccccc\n";
        char[] buffer=new char[32];
        int hasRead=0;
        try(
                StringReader sr=new StringReader(src)
                )
        {
            //采用循环读取的方式读取字符串
            while((hasRead=sr.read(buffer))>0){
                System.out.println(new String(buffer,0,hasRead));
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        try(
                //创建StringWriter时，实际上以一个StringBuffer作为输出节点
                //下面指定的20就是StringBuffer的初始长度
                StringWriter sw=new StringWriter()
                )
        {
            //调用StringWriter的方法执行输出
            sw.write("1111111111111\n");
            sw.write("2222222222222\n");
            sw.write("33333333333333333\n");
            System.out.println("------下面是sw字符串节点里的内容----------");
            System.out.println(sw.toString());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
