package Chapter15;

import java.nio.file.*;

public class WatchServiceTest {
    public static void main(String[] args)throws Exception {
        //获取文件系统的WatchService对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //为C：盘根路径注册监听
        Paths.get("F:/").register(watchService
                , StandardWatchEventKinds.ENTRY_CREATE
                , StandardWatchEventKinds.ENTRY_MODIFY
                , StandardWatchEventKinds.ENTRY_DELETE);
        while (true) {
            //获取下一个文件变化事件
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + "文件发生了" + event.kind() + "事件");
            }
            boolean vaild = key.reset();
            if (!vaild) {
                break;
            }
        }
    }
}
