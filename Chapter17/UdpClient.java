package Chapter17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    //定义发送数据报的目的地
    public static final int DEST_PORT=30000;
    public static String DEST_IP="127.0.0.1";
    //定义每个数据报的大小最大为4KB
    private static final int DATA_LEN=4096;
    //定义接受网络数据的字节数组
    byte[] intBuff=new byte[DATA_LEN];
    //以指定字节数组创建准备接受数据的DatagramPacket对象
    private DatagramPacket inPacket=
            new DatagramPacket(intBuff,intBuff.length);
    //定义一个用于发送的DatagramPacket对象
    private DatagramPacket outPacket=null;
    public void init()throws IOException{
        try(
                //创建一个客户端DatagramSocket，使用随机端口
                DatagramSocket socket=new DatagramSocket()
                ){
            //初始化发送用的DatagramSocket，它包含一个长度为0的字幕组
            outPacket=new DatagramPacket(new byte[0],0, InetAddress.getByName(DEST_IP),DEST_PORT);
            //创建键盘输入流
            Scanner scan=new Scanner(System.in);
            while(scan.hasNextLine()){
                byte[] buff=scan.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
                socket.receive(inPacket);
                System.out.println(new String(intBuff,0,inPacket.getLength()));
            }
        }

    }
    public static void main(String[] args)throws IOException{
        new UdpClient().init();
    }
}
