package Chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws Exception{
        /*Socket socket=new Socket();
        socket.connect(new InetAddress(host,post),10000);*/
        Socket socket=new Socket("127.0.0.1",30000);
        //设置10秒后即认为超时
        socket.setSoTimeout(10);
        /*//将Socket对应的输入流包装成BufferedReader
        BufferedReader br=new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        //进行普通IO操作
        String line=br.readLine();*/
        try{
            Scanner sc=new Scanner(socket.getInputStream());
            String line=sc.nextLine();
        System.out.println("来自服务器的数据："+line);
        sc.close();
        socket.close();

    }
    catch (SocketException se){
            se.printStackTrace();
    }
}}
