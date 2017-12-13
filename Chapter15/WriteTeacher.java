package Chapter15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteTeacher {
    public static void main(String[] args){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("teacher.txt"))){
            Person per=new Person("wukong",400);
            Teacher ter1=new Teacher("rulai",per);
            Teacher ter2=new Teacher("tang",per);
            oos.writeObject(ter1);
            oos.writeObject(ter2);
            oos.writeObject(per);
            oos.writeObject(ter2);
//            oos.writeObject(null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
