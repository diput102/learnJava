package Chapter15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Redirectln {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("FileTest.java")) {
            System.setIn(fis);
            Scanner sc=new Scanner(System.in);
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                System.out.println("输入内容"+sc.next());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
