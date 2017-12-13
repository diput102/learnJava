package Chapter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ps {
    public static void main(String[] args) throws IOException{
        File f=new File("a.txt");
        File d=new File("a2.txt");
        Test3.copyFile(f,d);
    }


}
