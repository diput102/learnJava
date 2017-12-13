package Chapter15;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String[] args)throws Exception{
        //复制文件
        Files.copy(Paths.get("FileTest.java"),new FileOutputStream("a1.txt"));
        //判断FilesTest。java文件是否为隐藏文件
        System.out.println("FileTest。java文件是否为隐藏文件"+ Files.isHidden(Paths.get("FileTest.java")));
        //一次性读取FilesTest.java文件的所有行
        List<String> lines=Files.readAllLines(Paths.get("FileTest.java"), Charset.forName("UTF-8"));
        System.out.println(lines);
        //判断指定文件大小
        System.out.println("FileTest.java的大小为"+Files.size(Paths.get("FileTest.java")));
        List<String> poem=new ArrayList<>();
        poem.add("水晶探底隐于月");
        poem.add("清旭风中笔杆哼");
        Files.write(Paths.get("poem.txt"),poem,Charset.forName("UTF-8"));
        Files.list(Paths.get(".")).forEach(path-> System.out.println(path));
        Files.lines(Paths.get("FileTest.java"),Charset.forName("UTF-8")).forEach(line-> System.out.println(line));
        FileStore cStore=Files.getFileStore(Paths.get("C:"));
        System.out.println("C:共有空间"+cStore.getTotalSpace());
        System.out.println("C:可用空间"+cStore.getUnallocatedSpace());

    }
}
