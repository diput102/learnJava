package Chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //15章第三题，实现copy文件内容功能
        //方法1,
        File fs = new File("F://test1");
        File fd = new File("F://test3");
        copyAll(fs, fd);
        //方法2
       // Files.copy(Paths.get("a.txt"), new FileOutputStream("aCopy2.txt"));
    }
    public static void copyAll(File f1,File f2)throws IOException{
        if(f1.isFile()){
            Test3.copyFile(f1,f2);
        }
        if(f1.isDirectory()){
            if(!f2.exists()){
                f2.mkdir();
            }
            File[] filelist=f1.listFiles();
            for(File f:filelist){
                copyAll(f,new File(f2,f.getName()));
            }

        }
    }

    public static void copyFile(File s, File t) throws IOException {

        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    }

