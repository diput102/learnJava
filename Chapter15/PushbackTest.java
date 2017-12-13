package Chapter15;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
    public static void main(String[] args){
        try(
                //创建一个PushbackReader对象，指定推回缓冲区的长度为64
                PushbackReader pr=new PushbackReader(new FileReader("FileTest.java"),64)
                )
        {
           char[] buf=new char[32];
           //用以保存上次读取的字符串内容
            String lastContent="";
            int hasReader=0;
            //循环读取文件内容
            while((hasReader=pr.read(buf))>0){
                //将读取的内容转换成字符串
                String content=new String(buf,0,hasReader);
                int targetContent=0;
                if((targetContent=(lastContent+content).indexOf("new File"))>0){
                    //将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent+content).toCharArray());
                    if(targetContent>32){
                        buf=new char[targetContent];
                    }
                    //
                    pr.read(buf,0,targetContent);
                    System.out.println(new String(buf,0,targetContent));
                    System.exit(0);
                }
                else{
                    System.out.println(lastContent);
                    lastContent=content;
                }
            }

        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
