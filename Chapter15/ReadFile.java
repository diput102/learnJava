package Chapter15;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args)throws IOException{
        FileChannel fic=new FileInputStream("FileTest.java").getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1048);
        while(fic.read(buffer)!=-1){
            buffer.flip();
            Charset charset=Charset.forName("UTF-8");
            CharsetDecoder decoder=charset.newDecoder();
            //解码：将二进制ByteBuffer解码成CharBuffer
            CharBuffer chuff=decoder.decode(buffer);
            System.out.println(chuff);
            buffer.clear();
        }

    }

}
