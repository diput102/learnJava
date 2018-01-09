package Chapter16;

public class Test1 {

//    int index = 1;
    boolean flag=false;

    public Test1() {
    }

    public synchronized void printNum(int i) {
        try {
            if(flag==true) {
                wait();
            }
                System.out.println(Thread.currentThread().getName() + " " + (i + 1));
//                index++;
            if(i%2==1){
                flag=true;
            }
                notify();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printWd(char m) {
        try {
            if(flag==false) {
                wait();
            }
                System.out.println(Thread.currentThread().getName() + m);
            flag=false;
//                index++;
                notify();
            }

         catch (Exception e) {
            e.printStackTrace();
        }
    }
}
