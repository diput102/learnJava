package Chapter17;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class UdpServer {
    public static final int PORT=30000;
    //定义每个数据报的大小最大为4KB
    private static final int DATA_LEN=4096;
    //定义接受网络数据的字节数组
    byte[] intBuff=new byte[DATA_LEN];
    //以指定字节数组创建准备接受数据的DatagramPacket对象
    private DatagramPacket inPacket=
            new DatagramPacket(intBuff,intBuff.length);
    //定义一个用于发送的DatagramPacket对象
    private DatagramPacket outPacket;
    //定义一个字符串数组，服务器端发送该数组的元素
    String[] books=new String[]{
            "AAAAAAAAA",
            "BBBBBBBBBB",
            "CCCCCCCCCCCCC",
            "dddddddddd"
    };
    public void init()throws IOException
    {
        try(
                //创建DatagramSocket对象
                DatagramSocket socket=new DatagramSocket(PORT)
                )
        {
         //采用循环接收数据
         for(int i=0;i<1000;i++){
             socket.receive(inPacket);
             System.out.println(intBuff==inPacket.getData());
             System.out.println(new String(intBuff,0,inPacket.getLength()));
             Scanner scan=new Scanner(System.in);
             byte[] sendData=books[i%4].getBytes();
             outPacket=new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
             socket.send(outPacket);
         }
        }
    }
    public static void main(String[] args)throws IOException{
        new UdpServer().init();
    }
}
