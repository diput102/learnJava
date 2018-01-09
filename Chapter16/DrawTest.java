package Chapter16;

public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("123455", 1000);
//        DrawThread dt1 = new DrawThread("甲取款者", acct, 800);
        DrawThread dt2 = new DrawThread("丁取款者", acct, 800);
        DpThread dp1 = new DpThread("乙存款者", acct, 800);
//        DpThread dp2 = new DpThread("丙存款者", acct, 800);
//        dt1.start();
        dt2.start();
        dp1.start();
//        dp2.start();
    }
}
