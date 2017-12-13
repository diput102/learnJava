package Chapter15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
    public static void main(String[] args){
        try(
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("replace.txt"));
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream("replace.txt"))
                )
        {
            Person p=new Person("abc",10);
            oos.writeObject(p);
            ArrayList list=(ArrayList)ois.readObject();
            System.out.println(list);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
