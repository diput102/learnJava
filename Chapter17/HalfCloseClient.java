package Chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseClient {
    public static void main(String[] args){
        try {
            Socket s = new Socket("localhost", 30004);
            Scanner sc=new Scanner(s.getInputStream());
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            PrintStream ps=new PrintStream(s.getOutputStream());
            ps.println("客户端信息");
            sc.close();
            ps.close();
            s.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
