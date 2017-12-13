package Chapter15;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
    public static void main(String[] args){
        File f=new File("a.txt");
        try(

                RandomAccessFile raf=new RandomAccessFile(f,"rw");
                FileChannel randomChannel=raf.getChannel()
                )
        {
            MappedByteBuffer buffer=randomChannel.map(FileChannel.MapMode.READ_ONLY,0,f.length());
            randomChannel.position(f.length());
            randomChannel.write(buffer);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

}
