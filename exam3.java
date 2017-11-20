package Chapter7.Chapter7Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//将A1B2C3D4E5F6G7H8拆分开来，并分别并存入int[]和String[]数组。得到的结果是[1,2,3,4,5,6,7,8]和[A,B,C,D,E,F,G,H]
public class exam3 {
    public static void main(String[] args){
        String s="A1B2C3D4E5F6G7H8";
        int[] it=new int[8];
        int i=0;
        int a=0;
        String[] sg=new String[18];
        Matcher m= Pattern.compile("\\d").matcher(s);
        while(m.find()){
                it[i]=Integer.valueOf(m.group());
                i++;
            }
        //把数字换成*，避免\\w还包括数字
        s=m.replaceAll("*");
        System.out.println(s);
        for(int n=0;n<8;n++){
            System.out.print(it[n]+" ");
            }
        Matcher m2=Pattern.compile("\\w").matcher(s);
        while(m2.find()){
            sg[a]=m2.group();
            a++;
        }
        for(int n=0;n<8;n++){
            System.out.print(sg[n]+" ");
        }

        }
    }

