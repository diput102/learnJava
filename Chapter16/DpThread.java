package Chapter16;

public class DpThread extends Thread {
    public Account account;
    private double dpAmount;

    public DpThread(String name, Account account, double dpAmount) {
        super(name);
        this.account = account;
        this.dpAmount = dpAmount;
    }

    public void run() {
        for (int i = 0; i < 2000; i++) {
            account.deposit(dpAmount);
        }
    }
}
