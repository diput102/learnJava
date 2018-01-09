package Chapter17;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseServer {
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(30004);
        Socket s=ss.accept();
        PrintStream ps=new PrintStream(s.getOutputStream());
        ps.println("服务器第一行数据");
        ps.println("服务器第二行数据");
        s.shutdownOutput();
        System.out.println(s.isClosed());
        Scanner sc=new Scanner(s.getInputStream());
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
        s.close();
        ss.close();
    }
}
