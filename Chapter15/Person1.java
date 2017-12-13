package Chapter15;

import java.io.IOException;
//实现Externalizable接口
public class Person1 implements java.io.Externalizable{
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
    public Person1(String n,int a){
        System.out.println("有参构造器");
        this.name=n;
        this.age=a;
    }
    public void writeExternal(java.io.ObjectOutput out)throws IOException{
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);

    }
    public void readExternal(java.io.ObjectInput in)throws IOException,ClassNotFoundException{
        this.name=((StringBuffer)in.readObject()).reverse().toString();
        this.age=in.readInt();
    }
}
