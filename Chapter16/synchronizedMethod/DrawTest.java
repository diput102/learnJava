package Chapter16.synchronizedMethod;

public class DrawTest {
    public static void main(String[] args) {
        Account acc = new Account("12345", 2000);
        DrawThread dt1 = new DrawThread("甲", acc, 800);
        DrawThread dt2 = new DrawThread("乙", acc, 800);
        dt1.start();
        dt2.start();
    }
}
