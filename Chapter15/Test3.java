package Chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //15章第三题，实现copy文件内容功能
        //方法1,
        File fs = new File("F://c++ primer 5");
        File fd = new File("F://test5");
        System.out.println(fs.toString());
        System.out.println(fd.exists());
        copyAll(fs, fd);
        //方法2
        // Files.copy(Paths.get("a.txt"), new FileOutputStream("aCopy2.txt"));
    }

    public static void copyAll(File f1, File f2) throws IOException {
        if (f1.isFile()) {
            Test3.copyFile(f1, f2);
        }
        if (f1.isDirectory()) {
            if (!f2.exists()) {
                f2.mkdir();
            }
            File[] filelist = f1.listFiles();
            for (File f : filelist) {
                copyAll(f, new File(f2, f.getName()));
            }

        }
    }

    public static void copyFile(File s, File t) throws IOException {

        FileChannel inChannel = new FileInputStream(s).getChannel();
        FileChannel outChannel = new FileOutputStream(t).getChannel();
        //方法一
//        MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY,0,s.length());
//        outChannel.write(buffer);
        //方法二
        inChannel.transferTo(0, inChannel.size(), outChannel);
    }

}

