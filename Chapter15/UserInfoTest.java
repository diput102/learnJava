package Chapter15;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

    public class UserInfoTest {

        /**
         * 序列化对象到文件
         * @param fileName
         */
        public static void serialize(String fileName){
            try {
                ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));

                out.writeObject("序列化的日期是：");//序列化一个字符串到文件
                out.writeObject(new Date());//序列化一个当前日期对象到文件
                UserInfo userInfo=new UserInfo("郭大侠","961012",21);
                out.writeObject(userInfo);//序列化一个会员对象

                out.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 从文件中反序列化对象
         * @param fileName
         */
        public static void deserialize(String fileName){
            try {
                ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));

                String str=(String) in.readObject();//刚才的字符串对象
                Date date=(Date) in.readObject();//日期对象
                UserInfo userInfo=(UserInfo) in.readObject();//会员对象

                System.out.println(str);
                System.out.println(date);
                System.out.println(userInfo);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args){
  serialize("text");
            deserialize("text");

            /**
             * 我修改了一下UserInfo的无参构造，在无参构造中给userAge属性赋值蛋反序列化得到的结果是userAge变成了20。
             * 得出结论：
             * 当从磁盘中读出某个类的实例时，如果该实例使用的是Externalizable序列化，会执行这个类的构造函数，
             * 然后调用readExternal给其他属性赋值
             */
        }

    }

