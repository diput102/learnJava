package Chapter15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args){
        try(
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream("object.txt"))

                )
        {
            Person p=(Person)ois.readObject();
            System.out.println("名字"+p.getName()+"年龄"+p.getAge());
        }
        catch (ClassNotFoundException |IOException ioe){
            ioe.printStackTrace();
        }
    }
}
