package Chapter15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args){
        try(
                RandomAccessFile raf=new RandomAccessFile("FileTest.java","r")
                ){
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置：" +raf.getFilePointer());
            //移动raf的文件记录指针的位置
            raf.seek(300);
            byte[] bbuf=new byte[1024];
            int hasRead=0;
            while((hasRead=raf.read(bbuf))>0){
                System.out.println(new String(bbuf,0,hasRead));
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

}
