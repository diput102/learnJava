package Chapter15;

import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args)throws Exception{
        try(FileReader fr=new FileReader("FileTest.java"))
        {
            char[] cbuf=new char[32];
            int hasRead=0;
            while((hasRead=fr.read(cbuf))>0){
                System.out.println(new String(cbuf,0,hasRead));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
