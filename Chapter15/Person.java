package Chapter15;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;

public class Person implements java.io.Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Person(String n, int a){
        System.out.println("有参数的构造器");
        this.name=n;
        this.age=a;
    }
    private void writeObject(java.io.ObjectOutputStream out)throws IOException{
        //序列化加密
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }
    private void readObject(java.io.ObjectInputStream in)throws IOException,ClassNotFoundException{
        this.name=((StringBuffer)in.readObject()).reverse().toString();
        this.age=in.readInt();
    }
    private Object writeReplace() throws ObjectStreamException{
        ArrayList<Object> list=new ArrayList<Object>();
        list.add(name);
        list.add(age);
        return list;

    }


}
