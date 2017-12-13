package Chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args){
        File f=new File("FileTest.java");
        try(
            //创建FileInputStream,以该文件输入流创建FileChannel
            FileChannel inChannel=new FileInputStream(f).getChannel();
            //以文件输出流创建FiLeChannel，用以控制输出
            FileChannel outChannel=new FileOutputStream("a.txt").getChannel())
        {
            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer=inChannel.map(FileChannel
                    .MapMode.READ_ONLY,0,f.length());
            //使用GBK的字符集来创建解码器
            //但是这样会报错java.nio.charset.MalformedInputException: Input length = 1
            //使用UFT-8可以解决乱码问题
            Charset charset=Charset.forName("UTF-8");
            //直接将buffer里的数据全部输出，将整个ByteBuffer的全部数据写入一个输出FileChannel中
            outChannel.write(buffer);
            //再次调用buffer的clear()方法，复原limit position的位置
            buffer.clear();
            //创建解码器（CharsetDecoder)对象
            CharsetDecoder decoder=charset.newDecoder();
            //使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer=decoder.decode(buffer);
            //CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
