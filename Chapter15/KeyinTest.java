package Chapter15;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args){
        try(
                //将System.in对象转换成Reader对象
                InputStreamReader reader=new InputStreamReader(System.in);
                //将普通的Reader包装成BufferedReader
                BufferedReader br=new BufferedReader(reader)
                )
        {
            String line=null;
            //采用循环的方式来读取
            while((line=br.readLine())!=null){
                //如果读取的字符串为“exit”，则程序退出
                if(line.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容"+line);
            }

        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
