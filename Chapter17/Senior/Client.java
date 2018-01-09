package Chapter17.Senior;

import Chapter17.ClientThread;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final int SERVER_PORT=30002;
    private PrintStream ps;
    private  Socket s;
    private BufferedReader brServer;
    private BufferedReader keyIn;
    public void init(){
        try{
            //初始化键盘输入流
            keyIn=new BufferedReader(new InputStreamReader(System.in));
            //连接到服务器端
            s=new Socket("127.0.0.1",SERVER_PORT);
            //获取该Socket的输入流
            brServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
            //获取服务器输出流
            ps=new PrintStream(s.getOutputStream());
            String tip="";
            //采用循环不断地弹出对话框要求输入用户名
            while(true){
                String userName= JOptionPane.showInputDialog(tip+"输入用户名");
                //在用户输入的用户名前后增加协议字符串后发送
                ps.println(CrazyitProtocol.USER_ROUND+userName+CrazyitProtocol.USER_ROUND);
                String result=brServer.readLine();
                if(result.equals(CrazyitProtocol.NAME_REP)){
                    tip="用户名重复，请重新输入";
                    continue;
                }
                if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
                    break;
                }
            }

        }
        //捕获到异常，关闭网络资源，并退出该程序
        catch (UnknownHostException ex){
            System.out.println("找不到服务器，请确定服务器已经启动");
            closeRs();
            System.exit(1);
        }
        catch (IOException ex){
            System.out.println("网络异常，请重新登陆！");
            closeRs();
            System.exit(1);
        }
        //以该socket对应的输入流启动ClientThread线程
        new Chapter17.Senior.ClientThread(brServer).start();
    }
    //定义一个读取键盘输出，并向网络发送的方法
    private void readAndSend(){
        try{
            String line=null;
            while((line=keyIn.readLine())!=null){
                //如果发送的信息中有冒号，且以//开头，则认为想发送私聊信息
                if(line.indexOf(":")>0&&line.startsWith("//")){
                    line=line.substring(2);
                    ps.println(CrazyitProtocol.PRIVATE_ROUND+line.split(":")[0]+CrazyitProtocol.SPLIT_SIGN+line.split(":")[1]
                    +CrazyitProtocol.PRIVATE_ROUND);
                }
                else{
                    ps.println(CrazyitProtocol.MSG_ROUND+line+CrazyitProtocol.MSG_ROUND);
                }
            }

        }
        //捕获到异常，关闭网络资源，并退出该程序
        catch (IOException ex){
            closeRs();
            System.exit(1);
        }
    }
    //关闭Socket输入流输出流方法
    private void closeRs(){
        try{
        if(keyIn!=null){
            keyIn.close();
        }
        if(brServer!=null){
            brServer.close();
        }
        if(s!=null){
            s.close();
        }
        if(ps!=null){
            ps.close();
        }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
}
public static void main(String[] args){
        Client client=new Client();
        client.init();
        client.readAndSend();
}
}
