package Chapter16;

public class DrawThread extends Thread {
    public Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        for (int i = 0; i < 200; i++) {
            account.draw(drawAmount);
        }
    }
}
