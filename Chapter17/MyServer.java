package Chapter17;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args)throws IOException{
        ServerSocket ss=new ServerSocket(30001);
        while(true){
            Socket s=ss.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }

    }
}
