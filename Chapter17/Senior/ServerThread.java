package Chapter17.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    BufferedReader br=null;
    PrintStream ps=null;
    //定义一个构造器，用于接收一个Socket来创建ServerThread线程
    public ServerThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            //获取该socket对应的输入流
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取该socket对应的输出流
            ps=new PrintStream(socket.getOutputStream());
            String line=null;
            while((line=br.readLine())!=null){
                //如果读取的输入流以USER_ROUND开始，并以此结束
                //则可以确定读到的是用户登陆的用户名
                if(line.startsWith(CrazyitProtocol.USER_ROUND)&&line.endsWith(CrazyitProtocol.USER_ROUND)){
                    //得到真实消息
                    String uesrName=getRealMsg(line);
                    for(PrintStream clientPs:Server.clients.valueSet()){
                        clientPs.println(uesrName+"用户已上线");
                    }
                    //如果用户名重复
                    if(Server.clients.map.containsKey(uesrName)){
                        System.out.println("重复");
                        ps.println(CrazyitProtocol.NAME_REP);
                    }
                    else{
                        System.out.println("成功");
                        ps.println(CrazyitProtocol.LOGIN_SUCCESS);
                        Server.clients.put(uesrName,ps);
                    }
                }
                //如果读到的行以PRIVATE_ROUND开始，并以此结束
                //则可以确定是私聊信息，私聊信息只向特定的输出流发送
                else if(line.startsWith(CrazyitProtocol.PRIVATE_ROUND)&&line.endsWith(CrazyitProtocol.PRIVATE_ROUND)){
                    //得到真实消息
                    String userAndMsg=getRealMsg(line);
                    //SPLIT_SIGN分割字符，前半部分是私聊用户，后部分是信息
                    String user=userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
                    String msg=userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
                    Server.clients.map.get(user).println(Server.clients.getKeyValue(ps)+"悄悄对你说"+msg);
                }
//                //有用户登录
//                //则向每个用户发送登陆提醒
//                else if(line.startsWith(CrazyitProtocol.DESIGN_MSG)&&line.endsWith(CrazyitProtocol.DESIGN_MSG)){
//                    //得到真实消息
//                    String userName;
//                }
                //公聊向每个用户发送
                else{
                    String msg=getRealMsg(line);
                    for(PrintStream clientPs:Server.clients.valueSet()){
                        clientPs.println(Server.clients.getKeyValue(ps)+"说"+msg);
                    }

                }
            }
        }
        //捕获到异常后，表明该Socket对应的客户端已经出现了问题
        //所以程序将其对应的输出流从Map中删除
        catch(IOException e){
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.map.size());
            //关闭网络，关闭IO资源
            try{
                if(br!=null){
                    br.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(socket!=null){
                    socket.close();
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }

        }
    }
    private String getRealMsg(String line){
        return line.substring(CrazyitProtocol.PROTOCOL_LEN,line.length()-CrazyitProtocol.PROTOCOL_LEN);
    }

}
