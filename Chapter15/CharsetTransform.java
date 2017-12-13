package Chapter15;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
    public static void main(String[] args)throws Exception{
        Charset cn=Charset.forName("GBK");
        CharsetEncoder cnEncoder=cn.newEncoder();
        CharsetDecoder cnDecoder=cn.newDecoder();
        CharBuffer buffer=CharBuffer.allocate(8);
        buffer.put('孙');
        buffer.put('悟');
        buffer.put('空');
        buffer.flip();
        ByteBuffer bbuf=cnEncoder.encode(buffer);
        for(int i=0;i<bbuf.capacity();i++){
            System.out.println(bbuf.get(i));
        }
        System.out.println(cnDecoder.decode(bbuf));
    }

}
