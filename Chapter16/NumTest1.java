package Chapter16;

public class NumTest1 extends Thread {
    public Test1 t1;
    public NumTest1(Test1 t1){
        this.t1=t1;
    }

    public void run(){
        for(int i=0;i<52;i++) {
            t1.printNum(i);
        }
    }

}
