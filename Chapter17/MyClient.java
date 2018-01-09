package Chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args)throws Exception{
        Socket s=new Socket("127.0.0.1",30001);
        //客户端启用ClientThread不断读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        //获取该数据的输出流
        PrintStream ps=new PrintStream(s.getOutputStream());
        String line=null;
        //不断的读取键盘输入
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while((line=br.readLine())!=null){
            //将用户的键盘输入写入输出流
            ps.println(line);
        }


    }
}
