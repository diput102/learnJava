package Chapter15;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {
    public static void main(String[] args) {
        try (
                ObjectInputStream oos = new ObjectInputStream(new FileInputStream("teacher.txt"))) {
     //       while(oos.readObject()!=null) {
            //如果使用这个判定 就已经把对象读出来了 后面的读的队列就会读不到 有问题，除非
            //Object obj=null while（obj=oos.readObject()!=null）{Teacher t1=obj；}
                Teacher t1 = (Teacher) oos.readObject();
                Teacher t2 = (Teacher) oos.readObject();
                Person p = (Person) oos.readObject();
                Teacher t3 = (Teacher) oos.readObject();
                System.out.println(p);
                System.out.println(t1.getName());
                System.out.println(t2.getName());
                System.out.println(t1.getStudent() == p);
                System.out.println(t2.getStudent() == p);
                System.out.println(t2 == t3);
//        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
