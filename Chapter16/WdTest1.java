package Chapter16;

public class WdTest1 extends Thread {
    public Test1 t1;

    public WdTest1(Test1 t1) {
        this.t1 = t1;
    }

    public void run() {
        for (char m = 'A'; m <= 'Z'; m++) {
            t1.printWd(m);
        }
    }
}
