package Chapter16;

public class MainTest1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Thread th1 = new NumTest1(t1);
        Thread th2 = new WdTest1(t1);
        Thread th3 = new WdTest1(t1);
        th1.start();
        th2.start();
        th3.start();
    }
}
