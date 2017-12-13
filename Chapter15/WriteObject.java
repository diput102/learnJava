package Chapter15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class WriteObject {
    public static void main(String[] args){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.txt")))
        {
            Person per=new Person("sunwukong",400);
            oos.writeObject(per);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
