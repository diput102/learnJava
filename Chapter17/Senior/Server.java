package Chapter17.Senior;

import Chapter17.ServerThread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int SERVER_PORT = 30002;
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

    public void init() {
        try (ServerSocket ss = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket s = ss.accept();
                new Chapter17.Senior.ServerThread(s).start();
            }
        } catch (IOException ex) {
            System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已被占用？");
        }
    }
}
